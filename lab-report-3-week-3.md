***PART 1:***
```
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
```


**SCREENSHOT 1:**

![Image](https://media.discordapp.net/attachments/890102969536753746/1030718371538407445/unknown.png)

By adding "/add?s=banana" to the URL, we have called the *handleRequest* method to check whether or not it is a command it recognizes and can run. It recognizes the "/add" in the URL, and adds the following text ("Banana") to the dictionary.


**SCREENSHOT 2:**

![Image](https://media.discordapp.net/attachments/890102969536753746/1030718576136568832/unknown.png)

Once again, like the previous link, the method *handleRequest* recognizes the "/add" in the URL, and adds "Apple" to the dictionary.

**SCREENSHOT 3:**

![Image](https://media.discordapp.net/attachments/890102969536753746/1030718668700659752/unknown.png)

Going back to the original URL lets us see the words in the dictionary, as *handleRequest* sees nothing after the / in the URL, and therefore prints out the contents of Dictionary.


**SCREENSHOT 4:**

![Image](https://media.discordapp.net/attachments/890102969536753746/1030718576136568832/unknown.png)

By adding "/search?s=na", the code recognizes the term "/search" in the URL, and will search all the words within dictionary to see if any of them contain the sequence of letters "na" in them. Banana has "na" in it, and therefore is displayed (however, "Apple", does not, so it is not shown).



***PART 2:***

**BUG 1:**

Location: ArrayExamples.java

Method: reverseInPlace

Failure Inducing Input: ArrayExamples.reverseInPlace({3, 4, 7)}

Symptom: at element\[2], expected:<3> but was:<7> --> *alue was in the incorrect place*

Bug: Actively changes the list while the code is working on it, giving it a jumble of useless numbers (overwrites it)

Connection: Since the numbers at the start of the list are changed to the numbers at the end of the list, by the time we get to the second half (and start changing all the numbers at the end), all of the numbers at the start that we have to reference have all been overwritten. In this specific case, when we get to the third element of the array, it looks at the first element of the array, which has already been changed to a different number (the value of the third element of the array), causing the third element to seemingly not change.

TEST:

![Image](https://cdn.discordapp.com/attachments/890102969536753746/1030732239539015701/unknown.png)


**BUG 2:**

Location: ListExamples.java

Method: filter

Failure Inducing Input: Attempting to filter a list for 2 different strings (using StringChecker, which checks if the string being observed is equal to either of the 2 strings implemented

Symptom: expected <\[Apple]> but was:<\[Banana]> --> *list was out of order*

Bug: New values are added to the start of the list, returning the results in reverse order rather than given order

Connection: This caused the result list to be created out of order, while the code intends the list to remain in order.

TEST:

![Image](https://media.discordapp.net/attachments/890102969536753746/1030732300612272138/unknown.png)
