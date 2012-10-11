package by.bsuir.banking.dotnetclient.test;

import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.AddressingFeature;

import com.sun.xml.internal.ws.client.BindingProviderProperties;

import by.bsuir.banking.dotnetclient.HelloWorldService;
import by.bsuir.banking.dotnetclient.IHelloWorldService;
import by.bsuir.banking.dotnetclient.ObjectFactory;
import by.bsuir.banking.dotnetclient.Person;
import by.bsuir.banking.dotnetclient.SayHello;

public class SayHelloTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectFactory factory = new ObjectFactory();
		SayHello sayHello = factory.createSayHello();
		Person person = factory.createPerson();
		person.setFirstName(factory.createPersonFirstName("Kate"));
		person.setLastName(factory.createPersonLastName("Krasnoschok"));
		sayHello.setPerson(factory.createPerson(person));
		
		HelloWorldService stub = new HelloWorldService();
		IHelloWorldService service = stub.getBasicHttpBindingIHelloWorldService();
		System.out.println(service.sayHello(person));
		

	}

}
