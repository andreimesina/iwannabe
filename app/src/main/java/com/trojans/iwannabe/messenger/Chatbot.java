package com.trojans.iwannabe.messenger;

public class Chatbot {
    public String userMessage;
    public String robotMessage;
    public int state;

    public Chatbot() {
        state = 0;
    }

    public void read(String msg) {
        userMessage = msg;
        userMessage = userMessage.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    public String write(String message) {
        ++state;
        robotMessage = message;
        return robotMessage;
    }

    public String run() {
        switch (state) {
            case 0:
                return write("Hey there!");
            case 1:
                if(!this.userMessage.contains("hello")
                        && !this.userMessage.contains("hi")) {
                    return write("Aren't you going to greet me?!");
                } else {
                    return write("Nice to meet you");
                }
            case 2:
                return write("Wanna hear a knock knock joke?");
            case 3:
                if(!this.userMessage.contains("yes")
                        && !this.userMessage.contains("sure")) {
                    return write("Too bad! Knock! Knock!");
                } else {
                    return write("Knock! Knock!");
                }
            case 4:
                if(this.userMessage.contains("who")
                        && this.userMessage.contains("there")) {
                    return write("No one");
                } else {
                    return write("You ruined my joke");
                }
            case 5:
                return write("...");
        }
        return "";
    }
}
