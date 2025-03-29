package pl.edu.pjwstk.s30900.pawkoz.L2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacadeService {

    private final String environment;
    private final Map<String, HandlerServiceInterface> serviceMap = new HashMap<>();

    public FacadeService(
            DevService devService,
            QaService qaService,
            ProdService prodService,
            StagingService stagingService,
            @Value("${app.environment:dev}") String environment
    ) {
        this.environment = environment;

        serviceMap.put("dev", devService);
        serviceMap.put("qa", qaService);
        serviceMap.put("prod", prodService);
        serviceMap.put("staging", stagingService);
    }

    public String execute() {
        if (environment == null) {
            return serviceMap.get("dev").handleRequest();
        }

        HandlerServiceInterface chosenService = serviceMap.get(environment.toLowerCase());
        if (chosenService == null) {
            return "Unknown environment: " + environment;
        }

        return chosenService.handleRequest();
    }
}

                                             //modyfikacja
//public class FacadeService {
//
//    private final DevService devService;
//    private final QaService qaService;
//    private final ProdService prodService;
//    private final StagingService stagingService;
//    private final String environment;
//
//    public FacadeService(
//            DevService devService,
//            QaService qaService,
//            ProdService prodService,
//            StagingService stagingService,
//            @Value("${app.environment:dev}") String environment
//    ) {
//        this.devService = devService;
//        this.qaService = qaService;
//        this.prodService = prodService;
//        this.stagingService = stagingService;
//        this.environment = environment;
//    }
//
//    public String execute() {
//        switch (environment.toLowerCase()) {
//            case "dev":
//                return devService.handleRequest();
//            case "qa":
//                return qaService.handleRequest();
//            case "prod":
//                return prodService.handleRequest();
//            case "staging":
//                return stagingService.handleRequest();
//            default:
//                return "Unknown env: " + environment;
//        }
//    }
//}
