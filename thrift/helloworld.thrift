namespace java com.tdias

typedef i32 int

service HelloService {

    string sayHello(),
    string sayHelloName(1: string name)

}