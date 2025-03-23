package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.stereotype.Component;

@Component
public class MySecondComponent {
    public MySecondComponent(MyFirstComponent myFirstComponent) {
//        System.out.println("Hello from MySecondComponent");
        myFirstComponent.printHelloMessage();
    }
    public void printSecondComponentAndClassName() {
//        System.out.println("Nazwa komponentu: MySecondComponent, nazwa klasy: " + this.getClass().getSimpleName());
    }
}
