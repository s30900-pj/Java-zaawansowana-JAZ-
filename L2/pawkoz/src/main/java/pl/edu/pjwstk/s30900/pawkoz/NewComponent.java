package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NewComponent {

    private final ApplicationContext applicationContext;

    public NewComponent(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        // Pobieramy beany z kontekstu
        MyFirstComponent myFirstComponent =
                applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
        MySecondComponent mySecondComponent =
                applicationContext.getBean("mySecondComponent", MySecondComponent.class);

        // Wywołujemy metody z MyFirstComponent
        myFirstComponent.printHelloMessage();
        myFirstComponent.printFirstComponentAndClassName();

        // Wywołujemy metodę z MySecondComponent
        mySecondComponent.printSecondComponentAndClassName();
    }
}
