package com.tdias;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by tdias on 8/3/15.
 */
public class HelloServer {

    public static HelloHandler handler;
    public static HelloService.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new HelloHandler();
            processor = new HelloService.Processor(handler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void simple(HelloService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            System.out.println("Starting simple server...");
            server.serve();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
