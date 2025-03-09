package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NewComponent {
    private final ApplicationContext applicationContext;

    public NewComponent(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        MyFirstComponent myFirstComponent =
                applicationContext.getBean("myFirstComponent", MyFirstComponent.class);

        MySecondComponent mySecondComponent =
                applicationContext.getBean("mySecondComponent", MySecondComponent.class);

        myFirstComponent.printHelloMessage();
        myFirstComponent.printFirstComponentAndClassName();
        mySecondComponent.printSecondComponentAndClassName();
    }
}
