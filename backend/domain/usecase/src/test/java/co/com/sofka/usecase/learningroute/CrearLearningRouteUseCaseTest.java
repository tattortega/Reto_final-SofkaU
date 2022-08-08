package co.com.sofka.usecase.learningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class CrearLearningRouteUseCaseTest {

    @InjectMocks
    RutaAprendizajeUseCase rutaAprendizajeUseCase;

    @Mock
    LearningRouteRepository learningRouteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRutaAprendizajeTest() {
        LearningRoute learningRoute = LearningRoute.builder()
                .id("1")
                .name("ruta 1")
                .description("descripcion")
                .level(1)
                .prerequisite("prerrequisito")
                .build();

        when(learningRouteRepository.findById("1")).thenReturn(Mono.just(learningRoute));

        StepVerifier.create(rutaAprendizajeUseCase.listarPorIdRutaAprendizaje("1"))
                .assertNext(ruta -> {
                    Assertions.assertEquals("1", ruta.getId());
                    Assertions.assertEquals("ruta 1", ruta.getName());
                    Assertions.assertEquals("descripcion", ruta.getDescription());
                    Assertions.assertEquals(1, ruta.getLevel());
                    Assertions.assertEquals("prerrequisito", ruta.getPrerequisite());
                })
                .expectComplete()
                .verify();
    }
}