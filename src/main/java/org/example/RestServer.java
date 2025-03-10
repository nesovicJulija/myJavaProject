package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class RestServer {

    // methods in this class allow searching for top 10 stocks for buying/selling
    private final Repository repository = new Repository();
    //from Jackson library, essential for serialization and deserialization
    private final ObjectMapper mapper = new ObjectMapper();

    public void start() throws IOException
    {
        // creating HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

        // POST request
        server.createContext("/orders", exchange -> {
            if("POST".equals(exchange.getRequestMethod()))
            {
                try{
                    System.out.println("POST request received!");
                    // trying deserialization
                    Order order = mapper.readValue(exchange.getRequestBody(), Order.class);
                    repository.add(order);

                    String response = "Order received!";
                    // 200 - signals ok
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream stream = exchange.getResponseBody();
                    stream.write(response.getBytes());
                    stream.close();

                    System.out.println("Response sent : " + response);

                }catch (Exception e)
                {
                    e.printStackTrace();
                    // 500 - signals internall error
                    exchange.sendResponseHeaders(500,0);
                    exchange.close();
                }

            }else{
                System.out.println("Invalid request received! " + exchange.getRequestMethod());
                // 405 method not allowed
                exchange.sendResponseHeaders(405,0);
                exchange.close();
            }
        });

        // GET request
        server.createContext("/orderbook/buy", exchange -> {
            // serialization into JSON
            String response = mapper.writeValueAsString(repository.getTop10TypeBuyOrders());

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream stream = exchange.getResponseBody();
            stream.write(response.getBytes());
            stream.close();
        });

        server.createContext("/orderbook/sell", exchange -> {
            // serialization into JSON
            String response = mapper.writeValueAsString(repository.getTop10TypeSellOrders());

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream stream = exchange.getResponseBody();
            stream.write(response.getBytes());
            stream.close();
        });

        // starting server
        server.start();
        System.out.println("REST server started!");
    }

    // we need this getter for data testing
    public Repository getRepository() {
        return repository;
    }
}