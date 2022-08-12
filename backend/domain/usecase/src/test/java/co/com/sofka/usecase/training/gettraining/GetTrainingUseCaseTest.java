package co.com.sofka.usecase.training.gettraining;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.course.Course;
import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.route.Route;
import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import co.com.sofka.usecase.training.getalltraining.GetAllTrainingUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetTrainingUseCaseTest {

    @InjectMocks
    GetTrainingUseCase getTrainingUseCase;

    @Mock
    TrainingRepository trainingRepository;

    @BeforeEach
    void setUp() {
        trainingRepository = mock(TrainingRepository.class);
        getTrainingUseCase = new GetTrainingUseCase(trainingRepository);
    }

    @Test
    void getTrainingTest() {
        String name = "Desarrollo de software";
        String description = "Full-stack programacion";
        LocalDate startDate = LocalDate.parse("2022-08-10");
        LocalDate endDate = LocalDate.parse("2022-12-10");
        String coach = "Julian Lasoo";
        Course course = new Course("1", "Spring boot", "Java-Spring boot-MySQL", 80);
        List<Route> routeList = new ArrayList<>();
        routeList.add(new Route(1, course, null));
        LearningRoute learningRoute = new LearningRoute("1", "Backend", "Java-Spring boot", routeList);
        List<Apprentice> apprentices = new ArrayList<>();
        apprentices.add(new Apprentice("1", "Luis", "Ortega", "cucuta", "masculino", "tatto@mail.com", 123456, "url", false));
        apprentices.add(new Apprentice("2", "Ricardo", "Mantilla", "bogota", "masculino", "tattortega@mail.com", 78956, "url", true));
        Training training1 = new Training("1", name, description, startDate, endDate, coach, learningRoute, apprentices);
        Mono<Training> trainingMono = Mono.just(training1);

        when(trainingRepository.save(Mockito.any(Training.class))).thenReturn(trainingMono);
        when(trainingRepository.findById(training1.getId())).thenReturn(trainingMono);

        StepVerifier.create(getTrainingUseCase.apply(training1.getId()))
                .expectNextMatches(training -> {
                    assert training.getId().equals("1");
                    assert training.getName().equals(name);
                    assert training.getDescription().equals(description);
                    assert training.getStartDate().equals(startDate);
                    assert training.getEndDate().equals(endDate);
                    assert training.getCoach().equals(coach);
                    assert training.getLearningRoute().equals(learningRoute);
                    assert training.getApprentices().equals(apprentices);
                    return true;
                })
                .verifyComplete();

        verify(trainingRepository).findById(training1.getId());

    }
}
