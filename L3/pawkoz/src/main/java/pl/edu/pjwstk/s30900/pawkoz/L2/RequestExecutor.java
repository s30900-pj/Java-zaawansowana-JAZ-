package pl.edu.pjwstk.s30900.pawkoz.L2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RequestExecutor implements CommandLineRunner {

    private final FacadeService facadeService;

    public RequestExecutor(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @Override
    public void run(String... args) throws Exception {
        String result = facadeService.execute();
        System.out.println(result);
    }
}
