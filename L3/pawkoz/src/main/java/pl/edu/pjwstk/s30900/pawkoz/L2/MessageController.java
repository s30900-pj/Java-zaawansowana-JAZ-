package pl.edu.pjwstk.s30900.pawkoz.L2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final FacadeService facadeService;

    public MessageController(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @GetMapping("/message")
    public String getMessage() {
        return facadeService.execute();
    }
}
