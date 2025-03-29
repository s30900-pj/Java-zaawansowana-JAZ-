package pl.edu.pjwstk.s30900.pawkoz.L3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @GetMapping("/variable/{info}")
    public ResponseEntity<String> getInfoByPathVariable(@PathVariable String info) {
        String response = "Your path variable is: " + info;
        return ResponseEntity.ok(response);
    }
    @GetMapping("/param")
    public ResponseEntity<String> getInfoByRequestParam(@RequestParam String info) {
        String response = "Your request param is: " + info;
        return ResponseEntity.ok(response);
    }

}

