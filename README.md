# identity-class

The code assignment is done using Java. I chose Java because it is the language I have most experience on OOP through my studies.

I looked at the problem as a huge possibility for regex. Given specific path (login, confirm or sign) there were always specific parameters with specific form of data. For example with path "sign" there is parameter "documentid" which is alphanumeric string and therefore easy to validate using regex. In my solution there is alot of regex and splitting to handle both validation and handling of given URI's.

My program has separate Client class, which is the main class of the program. It gives the user to opportunity to play as an app which is making a call for the request identifier. Normally these URI's would come somewhere else ofcourse.

The biggest challenge I faced during the development was the logic behind splitting and validation. If I had more time, I would improve the logic to be more simpler and straight-forward. The solution is also extremely procedural-heavy. If I had more time and mental resources, I would have made the program more object-oriented and I had already plans on transforming it to more object-oriented but was not able to perform the changes.
