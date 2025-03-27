package pl.edu.pjwstk.s30900.pawkoz.L1;

public class MySecondComponentXML {

    private final MyFirstComponentXML myFirstComponent;

    public MySecondComponentXML(MyFirstComponentXML myFirstComponent) {
        this.myFirstComponent = myFirstComponent;
//        System.out.println("Hello from MySecondComponentXML");
        myFirstComponent.printHelloMessage();
    }

    public void printSecondComponentAndClassName() {
//        System.out.println("Nazwa komponentu: MySecondComponentXML, nazwa klasy: " + this.getClass().getSimpleName());
    }
}