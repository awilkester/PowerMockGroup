package main.java;

public class Utility {

    public static String staticMethod(String message) {
        return message;
    }

    public final String finalMethod(String message) {
        return message;
    }

    private String privateMethod(String message) {
        return message;
    }

    public String callPrivateMethod(String message) {
        return privateMethod(message);
    }


}