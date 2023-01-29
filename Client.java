import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* This is the client class of the request identifier. 
It takes input from the user as if user was an app making the call and then passes into the Identifier class */

public class Client {
    public static void main(String[] args) {
        Identifier identifier = Identifier.getInstance();
        String request = "";

        System.out.println("Welcome to pretend you are an app making a call to the request identifier:)");
        System.out.print("Your URI: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            request = input.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        identifier.identifyRequest(request);
    }
}