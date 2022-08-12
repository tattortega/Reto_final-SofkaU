package co.com.sofka.usecase.training.getalltraining;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.course.Course;
import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.route.Route;
import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import co.com.sofka.usecase.training.deletetraining.DeleteTrainingUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetAllTrainingUseCaseTest {

    @InjectMocks
    GetAllTrainingUseCase getAllTrainingUseCase;

    @Mock
    TrainingRepository trainingRepository;

    @BeforeEach
    void setUp() {
        trainingRepository = mock(TrainingRepository.class);
        getAllTrainingUseCase = new GetAllTrainingUseCase(trainingRepository);
    }

    @Test
    void getAllTrainingsTest() {
        String name = "Desarrollo de software";
        String description = "Full-stack programacion";
        LocalDate startDate = LocalDate.parse("2022-08-10");
        LocalDate endDate = LocalDate.parse("2022-12-10");
        String coach = "Julian Lasoo";
        Course course = new Course("1", "Spring boot", "Java-Spring boot-MySQL", 80);
        List<Route> routeList = new ArrayList<>();
        routeList.add(new Route(1, course, null));
        LearningRoute learningRoute = new LearningRoute("1", "Backend", "Java-Spring boot", routeList);        List<Apprentice> apprentices = new ArrayList<>();
        apprentices.add(new Apprentice("1", "Luis", "Ortega", "cucuta", "masculino", "tatto@mail.com", 123456, "url", false));
        apprentices.add(new Apprentice("2", "Ricardo", "Mantilla", "bogota", "masculino", "tattortega@mail.com", 78956, "url", true));
        Training training1 = new Training("1", name, description, startDate, endDate, coach, learningRoute, apprentices);

        String name2 = "Automatizacion de pruebas";
        String description2 = "Pruebas funcionales, unitarias";
        LocalDate startDate2 = LocalDate.parse("2022-05-10");
        LocalDate endDate2 = LocalDate.parse("2022-08-10");
        String coach2 = "Manuel Salas";
        Course course2 = new Course("1", "TDD", "Pruebas", 80);
        List<Route> routeList2 = new ArrayList<>();
        routeList2.add(new Route(1, course2, null));
        LearningRoute learningRoute2 = new LearningRoute("1", "Pruebas unitarias", "JUnit", routeList2);
        List<Apprentice> apprentices2 = new ArrayList<>();
        apprentices.add(new Apprentice("1", "Luis", "Ortega", "cucuta", "masculino", "tatto@mail.com", 123456, "url", false));
        apprentices.add(new Apprentice("2", "Ricardo", "Mantilla", "bogota", "masculino", "tattortega@mail.com", 78956, "url", true));
        Training training2 = new Training("1", name2, description2, startDate2, endDate2, coach2, learningRoute2, apprentices2);

        Flux<Training> trainingFlux = Flux.just(training1, training2);

        when(trainingRepository.findAll()).thenReturn(trainingFlux);

        StepVerifier.create(getAllTrainingUseCase.get())
                .expectNextCount(2)
                .verifyComplete();

        verify(trainingRepository).findAll();

    }
}
