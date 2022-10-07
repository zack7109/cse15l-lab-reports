import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> Dictionary = new ArrayList<String>();
    ArrayList<String> ReturnWords = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello! These are the words in your dictionary: %s", Dictionary.toString());
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    Dictionary.add(parameters[1]);
                    return String.format("%s has been added to your dictionary", parameters[1]);
                }
                
            }
            else if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    ReturnWords.clear();
                    for (String word : Dictionary){
                        if (word.contains(parameters[1])){
                            ReturnWords.add(word);
                        }
                    }
                    return String.format("The dictionary has found %s in your dictionary", ReturnWords.toString());
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
