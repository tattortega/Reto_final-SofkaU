package co.com.sofka.usecase.learningroute.updatelearningroute;

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

class UpdateLearningRouteUseCaseTest {

    @InjectMocks
    UpdateLearningRouteUseCase updateLearningRouteUseCase;

    @Mock
    LearningRouteRepository learningRouteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateLearningRouteTest() {
        LearningRoute learningRoute = LearningRoute.builder()
                .id("1")
                .name("ruta 1")
                .description("descripcion")
                .level(1)
                .prerequisite("prerrequisito")
                .build();

        LearningRoute learningRouteUpdate = LearningRoute.builder()
                .id("1")
                .name("ruta update")
                .description("descripcion update")
                .level(1)
                .prerequisite("prerrequisito update")
                .build();

        when(learningRouteRepository.save(learningRoute)).thenReturn(Mono.just(learningRoute));
        when(learningRouteRepository.update("1", learningRouteUpdate)).thenReturn(Mono.just(learningRouteUpdate));

        StepVerifier.create(updateLearningRouteUseCase.apply("1", learningRouteUpdate))
                .assertNext(route -> {
                    Assertions.assertEquals("1", route.getId());
                    Assertions.assertEquals("ruta update", route.getName());
                    Assertions.assertEquals("descripcion update", route.getDescription());
                    Assertions.assertEquals(1, route.getLevel());
                    Assertions.assertEquals("prerrequisito update", route.getPrerequisite());
                })
                .expectComplete()
                .verify();
    }
}