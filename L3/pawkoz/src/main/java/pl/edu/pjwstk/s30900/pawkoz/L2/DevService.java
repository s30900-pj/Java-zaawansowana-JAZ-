package pl.edu.pjwstk.s30900.pawkoz.L2;

import org.springframework.stereotype.Service;

@Service
public class DevService implements HandlerServiceInterface {
    @Override
    public String handleRequest() {
        return "Hello from Dev";
    }
}
