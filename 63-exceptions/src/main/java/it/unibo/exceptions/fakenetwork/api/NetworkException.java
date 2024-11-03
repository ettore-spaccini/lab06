package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException () {
        super("Network error: no response");
    }

    public NetworkException (final String str) {
        super("Network error while sending message: " + str);
    }
}
