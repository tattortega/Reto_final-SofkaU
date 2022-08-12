//package co.com.sofka.usecase.learningroute.deletelearningroute;
//
//import co.com.sofka.model.learningroute.LearningRoute;
//import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.mockito.Mockito.when;
//
//class DeleteLearningRouteUseCaseTest {
//
//    @InjectMocks
//    DeleteLearningRouteUseCase deleteLearningRouteUseCase;
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
//    void deleteLearningRouteTest() {
//        LearningRoute learningRoute = LearningRoute.builder()
//                .id("1")
//                .name("ruta 1")
//                .description("descripcion")
//                .level(1)
//                .prerequisite("prerrequisito")
//                .build();
//
//        when(learningRouteRepository.deleteById("1")).thenReturn(Mono.empty());
//
//        StepVerifier.create(deleteLearningRouteUseCase.apply("1"))
//                .expectComplete()
//                .verify();
//    }
//}