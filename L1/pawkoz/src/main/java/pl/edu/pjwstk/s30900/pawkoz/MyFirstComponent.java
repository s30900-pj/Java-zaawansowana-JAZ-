package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.stereotype.Component;

@Component
public class MyFirstComponent {
    public MyFirstComponent() {
        System.out.println("Hello from MyFirstComponent");
    }
    public void printHelloMessage(){
        System.out.println("Hello from MyFirstComponent from method printHelloMessage");
    }
    public void printFirstComponentAndClassName() {
        System.out.println("Nazwa komponentu: MyFirstComponent, nazwa klasy: " + this.getClass().getSimpleName());
    }
}
