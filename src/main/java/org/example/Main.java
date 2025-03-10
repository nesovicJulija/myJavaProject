package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

        // starting server
        RestServer restServer = new RestServer();
        restServer.start();

        // test data
        restServer.getRepository().initializeData();
        System.out.println("Testing data initialized!");
    }
}