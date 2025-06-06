package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.stereotype.Component;

@Component
public class MyFirstComponentXML {
    public MyFirstComponentXML() {
        System.out.println("Hello from MyFirstComponentXML");
    }

    public void printHelloMessage() {
        System.out.println("Hello from MyFirstComponentXML (printHelloMessage)");
    }

    public void printFirstComponentAndClassName() {
        System.out.println("Nazwa komponentu: MyFirstComponentXML, nazwa klasy: " + this.getClass().getSimpleName());
    }

}
