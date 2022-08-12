package co.com.sofka.usecase.training.updatetraining;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.course.Course;
import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import co.com.sofka.usecase.training.gettraining.GetTrainingUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateTrainingUseCaseTest {

    @InjectMocks
    UpdateTrainingUseCase updateTrainingUseCase;

    @Mock
    TrainingRepository trainingRepository;

    @BeforeEach
    void setUp() {
        trainingRepository = mock(TrainingRepository.class);
        updateTrainingUseCase = new UpdateTrainingUseCase(trainingRepository);
    }

    @Test
    void updateTrainingTest() {
        String name = "Desarrollo de software";
        String description = "Full-stack programacion";
        LocalDate startDate = LocalDate.parse("2022-08-10");
        LocalDate endDate = LocalDate.parse("2022-12-10");
        String coach = "Julian Lasoo";
        Course course = new Course("1", "Spring boot", "Java-Spring boot-MySQL", 80);
        LearningRoute learningRoute = new LearningRoute("1", "Backend", "Java-Spring boot", 1, course, "java");
        List<Apprentice> apprentices = new ArrayList<>();
        apprentices.add(new Apprentice("1", "Luis", "Ortega", "cucuta", "masculino", "tatto@mail.com", 123456, "url", false));
        apprentices.add(new Apprentice("2", "Ricardo", "Mantilla", "bogota", "masculino", "tattortega@mail.com", 78956, "url", true));
        Training training1 = new Training("1", name, description, startDate, endDate, coach, learningRoute, apprentices);
        Mono<Training> trainingMono = Mono.just(training1);

        String nameUpdate = "Desarrollo de software";
        String descriptionUpdate = "Programacion backend Java-Spring boot";
        String coachUpdate = "Raul Alzate";
        apprentices.add(new Apprentice("1", "Saul", "Perez", "medellin", "masculino", "tatto@mail.com", 123456, "url", false));
        apprentices.add(new Apprentice("2", "Andres", "Rodriguez", "pereira", "masculino", "tattortega@mail.com", 78956, "url", true));
        Training trainingUpdate = new Training("1", nameUpdate, descriptionUpdate, startDate, endDate, coachUpdate, learningRoute, apprentices);
        Mono<Training> trainingMonoUpdate = Mono.just(trainingUpdate);


        when(trainingRepository.save(Mockito.any(Training.class))).thenReturn(trainingMono);
        when(trainingRepository.update(training1.getId(), trainingUpdate)).thenReturn(trainingMonoUpdate);


        StepVerifier.create(updateTrainingUseCase.apply(training1.getId(), trainingUpdate))
                .expectNextMatches(training -> {
                    assert training.getId().equals("1");
                    assert training.getName().equals(nameUpdate);
                    assert training.getDescription().equals(descriptionUpdate);
                    assert training.getStartDate().equals(startDate);
                    assert training.getEndDate().equals(endDate);
                    assert training.getCoach().equals(coachUpdate);
                    assert training.getLearningRoute().equals(learningRoute);
                    assert training.getApprentices().equals(apprentices);
                    return true;
                })
                .verifyComplete();
    }
}
