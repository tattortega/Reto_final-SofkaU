//package co.com.sofka.usecase.learningroute.getalllearningroute;
//
//import co.com.sofka.model.learningroute.LearningRoute;
//import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import reactor.core.publisher.Flux;
//import reactor.test.StepVerifier;
//
//import static org.mockito.Mockito.when;
//
//class GetAllLearningRouteUseCaseTest {
//
//    @InjectMocks
//    GetAllLearningRouteUseCase getAllLearningRouteUseCase;
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
//    void getAllLearningRouteTest() {
//        LearningRoute learningRoute1 = LearningRoute.builder()
//                .id("1")
//                .name("ruta 1")
//                .description("descripcion")
//                .level(1)
//                .prerequisite("prerrequisito")
//                .build();
//
//        LearningRoute learningRoute2 = LearningRoute.builder()
//                .id("2")
//                .name("ruta 2")
//                .description("descripcion")
//                .level(1)
//                .prerequisite("prerrequisito")
//                .build();
//
//        Flux<LearningRoute> routeFlux = Flux.just(learningRoute1, learningRoute2);
//
//        when(learningRouteRepository.findAll()).thenReturn(routeFlux);
//
//        StepVerifier.create(getAllLearningRouteUseCase.get())
//                .expectNextCount(2)
//                .expectComplete()
//                .verify();
//    }
//}