package co.com.sofka.usecase.learningroute.getlearningroute;

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

class GetLearningRouteUseCaseTest {

    @InjectMocks
    GetLearningRouteUseCase getLearningRouteUseCase;

    @Mock
    LearningRouteRepository learningRouteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getLearningRouteTest() {
        LearningRoute learningRoute = LearningRoute.builder()
                .id("1")
                .name("ruta 1")
                .description("descripcion")
                .build();

        when(learningRouteRepository.findById("1")).thenReturn(Mono.just(learningRoute));

        StepVerifier.create(getLearningRouteUseCase.apply("1"))
                .assertNext(route -> {
                    Assertions.assertEquals("1", route.getId());
                    Assertions.assertEquals("ruta 1", route.getName());
                    Assertions.assertEquals("descripcion", route.getDescription());
                })
                .expectComplete()
                .verify();
    }
}