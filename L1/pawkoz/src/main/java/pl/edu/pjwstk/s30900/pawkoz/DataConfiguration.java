package pl.edu.pjwstk.s30900.pawkoz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfiguration {

    @Value("${my.custom.property:Hello from default property}")
    private String myCustomProperty;

    @Bean
    public PlainOldJavaObject plainOldJavaObject() {
        System.out.println("Wartość my.custom.property: " + myCustomProperty);

        return new PlainOldJavaObject("Alice", 25);
    }
    @Bean
    public List<String> defaultData() {
        return List.of("One", "Two", "Three", "Four", "Five");
    }
}
