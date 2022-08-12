//package co.com.sofka.usecase.learningroute.createlearningroute;
//
//import co.com.sofka.model.learningroute.LearningRoute;
//import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
//import co.com.sofka.usecase.learningroute.getlearningroute.GetLearningRouteUseCase;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.mockito.Mockito.when;
//
//class CreateLearningRouteUseCaseTest {
//
//    @InjectMocks
//    CreateLearningRouteUseCase createLearningRouteUseCase;
//
//    @Mock
//    LearningRouteRepository learningRouteRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createLearningRouteTest() {
//        LearningRoute learningRoute = LearningRoute.builder()
//                .id("1")
//                .name("ruta 1")
//                .description("descripcion")
//                .level(1)
//                .prerequisite("prerrequisito")
//                .build();
//
//        when(learningRouteRepository.save(Mockito.any(LearningRoute.class))).thenReturn(Mono.just(learningRoute));
//
//        StepVerifier.create(createLearningRouteUseCase.apply(learningRoute))
//                .assertNext(ruta -> {
//                    Assertions.assertEquals("1", ruta.getId());
//                    Assertions.assertEquals("ruta 1", ruta.getName());
//                    Assertions.assertEquals("descripcion", ruta.getDescription());
//                    Assertions.assertEquals(1, ruta.getLevel());
//                    Assertions.assertEquals("prerrequisito", ruta.getPrerequisite());
//                })
//                .expectComplete()
//                .verify();
//    }
//}