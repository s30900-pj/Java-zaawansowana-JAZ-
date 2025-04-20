package pl.edu.pjwstk.s30900.pawkoz.L4.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.s30900.pawkoz.L4.model.Car;
import pl.edu.pjwstk.s30900.pawkoz.L4.service.CarService;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    private final CarService carService;

    // Wstrzykiwanie zależności przez konstruktor
    public HomeworkController(CarService carService) {
        this.carService = carService;
    }

    // 1. GET z PathVariable
    @GetMapping("/{info}")
    public ResponseEntity<String> getInfoByPathVariable(@PathVariable String info) {
        String response = "Your path variable is: " + info;
        return ResponseEntity.ok(response);
    }

    // 2. GET z RequestParam
    @GetMapping
    public ResponseEntity<String> getInfoByRequestParam(@RequestParam String info) {
        String response = "Your request param is: " + info;
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
        Car created = carService.createCar(newCar);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car found = carService.getCar(id);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car updated = carService.updateCar(id, updatedCar);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exception")
    public ResponseEntity<String> throwException() {
        throw new RuntimeException("To jest błąd!");
    }
}