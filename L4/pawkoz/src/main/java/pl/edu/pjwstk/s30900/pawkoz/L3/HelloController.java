package pl.edu.pjwstk.s30900.pawkoz.L3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.s30900.pawkoz.L4.model.Car;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHelloWithoutParam() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getCarModel() {
        Car sampleCar = new Car("Toyota", "Corolla", 2015);
        return ResponseEntity.ok(sampleCar);
    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> saySomething(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping(value = "/hello", params = "reqParam")
    public ResponseEntity<String> sayHelloWithParam(@RequestParam("reqParam") String param) {
        return ResponseEntity.ok(param);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> createCar(@RequestBody Car requestCar) {

        Car newCar = new Car(
                requestCar.getBrand(),
                requestCar.getModel(),
                requestCar.getYear()
        );
        return ResponseEntity.ok(newCar);
    }
}