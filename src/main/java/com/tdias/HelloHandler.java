package com.tdias;

import org.apache.thrift.TException;

/**
 * Created by tdias on 8/3/15.
 */
public class HelloHandler implements HelloService.Iface {

    @Override
    public String sayHello() throws TException {
        return "Hello World!";
    }

    @Override
    public String sayHelloName(String name) throws TException {
        return "Hello " + name;
    }
}
