package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.stereotype.Component;

@Component
public class MySecondComponent {
    private final MyFirstComponentXML myFirstComponent;

    // Konstruktor, do którego wstrzykujemy zależność MyFirstComponentXML
    public MySecondComponentXML(MyFirstComponentXML myFirstComponent) {
        this.myFirstComponent = myFirstComponent;
        System.out.println("Hello from MySecondComponentXML");
        myFirstComponent.printHelloMessage();
    }

    public void printSecondComponentAndClassName() {
        System.out.println("Nazwa komponentu: MySecondComponentXML, nazwa klasy: " + this.getClass().getSimpleName());
    }
}
