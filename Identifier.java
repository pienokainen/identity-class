import java.util.Properties;

public class Identifier {
    private static Identifier single_instance=null;

    public static Identifier getInstance() {
        if (single_instance == null) 
        { 
            single_instance = new Identifier(); 
        } 
        return single_instance; 
    }

    public void identifyRequest(String request) {
        // Check whether Scheme and Path are correct
        boolean matchFound = request.matches("^visma-identity://[login|confirm|sign].*");

        if (matchFound)  {
            // Split scheme and rest of the input
            String[] urischeme = request.split("://");
            // Split path from rest of the input from question mark
            String[] parameters = urischeme[1].split("\\?");
            // Send parameters to another class to check & display them
            Properties props = identifyPathParameters(parameters);
            printParameters(props);
        } else {
            System.out.println("Request does not have correct scheme or path.");
        }
    }

    private Properties identifyPathParameters(String[] parameters) {
        Properties props = new Properties();

        // Display chosen path to user (or app in this case)
        String path = parameters[0];
        System.out.println("The chosen path is " + path);

        // Check if specific path and parameters match and save them into a list
        if (path.equals("login")) {
            boolean result = parameters[1].matches("^source=[a-zA-Z]+");
            if (result) {
                String[] source = parameters[1].split("=");
                props.setProperty(source[0], source[1]);
            } else {
                System.out.println("Source type does not match with login path.");
            }
        } else if (path.equals("confirm")) {
            boolean result = parameters[1].matches("^source=[a-zA-Z]+&paymentnumber=[0-9]+");
            if (result) {
                String[] pairs = parameters[1].split("&", 2);
                for (String pair: pairs) {
                    String[] source = pair.split("=");
                    props.setProperty(source[0], source[1]);
                }
            } else {
                System.out.println("Source type does not match with confirm path.");
            }
        } else {
            boolean result = parameters[1].matches("^source=[a-zA-Z]+&documentid=[a-z0-9]+");
            if (result) {
                String[] pairs = parameters[1].split("&", 3);
                for (String pair: pairs) {
                    String[] source = pair.split("=");
                    props.setProperty(source[0], source[1]);
                }
            } else {
                System.out.println("Source type does not match with sign path.");
            }
        }
        return props;
    }
    
    private void printParameters(Properties props) {
        System.out.println("Found key-value pairs are listed below");
        for (Object key: props.keySet()) {
            System.out.println(key + ": " + props.getProperty(key.toString()));
        }
    }
}