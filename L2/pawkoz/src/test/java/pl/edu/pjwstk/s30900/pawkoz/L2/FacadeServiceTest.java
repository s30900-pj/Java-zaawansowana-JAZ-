package pl.edu.pjwstk.s30900.pawkoz.L2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeServiceTest {
    @Test
    void shouldReturnDevMessageWhenEnvIsDev() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                "dev"
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Hello from Dev", result);
    }

    @Test
    void shouldReturnQaMessageWhenEnvIsQa() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                "qa"
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Hello from QA", result);
    }

    @Test
    void shouldReturnProdMessageWhenEnvIsProd() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                "prod"
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Hello from Prod", result);
    }

    @Test
    void shouldReturnStagingMessageWhenEnvIsStaging() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                "staging"
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Hello from Staging", result);
    }

    @Test
    void shouldReturnDevMessageWhenEnvIsUnknown() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                "WRONG_ENV"
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Unknown environment: WRONG_ENV", result);
    }

    @Test
    void shouldReturnDevWhenNoEnvironmentValue() {
        // given
        FacadeService facadeService = new FacadeService(
                new DevService(),
                new QaService(),
                new ProdService(),
                new StagingService(),
                null
        );

        // when
        String result = facadeService.execute();

        // then
        assertEquals("Hello from Dev", result);
    }
}