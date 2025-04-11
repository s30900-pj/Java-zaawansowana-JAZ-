package pl.edu.pjwstk.s30900.pawkoz.L3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @GetMapping("/{info}")
    public ResponseEntity<String> getInfoByPathVariable(@PathVariable String info) {
        String response = "Your path variable is: " + info;
        return ResponseEntity.ok(response);
    }
    @GetMapping("")
    public ResponseEntity<String> getInfoByRequestParam(@RequestParam String info) {
        String response = "Your request param is: " + info;
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return ResponseEntity.ok(updatedCar);
    }
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
        return ResponseEntity.ok(newCar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}

