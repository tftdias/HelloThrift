package com.tdias;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by tdias on 8/3/15.
 */
public class HelloClient {

    public static void main(String[] args) {

        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);

            perform(client);

            transport.close();
        }
        catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void perform(HelloService.Client client) throws TException {
        System.out.println(client.sayHello());
        System.out.println(client.sayHelloName("Tiago"));
    }
}
