package co.com.sofka.usecase.training.deletetraining;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.course.Course;
import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteTrainingUseCaseTest {

    @InjectMocks
    DeleteTrainingUseCase deleteTrainingUseCase;

    @Mock
    TrainingRepository trainingRepository;

    @BeforeEach
    void setUp() {
        trainingRepository = mock(TrainingRepository.class);
        deleteTrainingUseCase = new DeleteTrainingUseCase(trainingRepository);
    }

    @Test
    void deleteTrainingTest() {
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
        Training training = new Training("1", name, description, startDate, endDate, coach, learningRoute, apprentices);


        when(trainingRepository.findById(training.getId())).thenReturn(Mono.just(training));
        when(trainingRepository.deleteById(training.getId())).thenReturn(Mono.empty());

        StepVerifier.create(deleteTrainingUseCase.apply(training.getId()))
                .verifyComplete();

        verify(trainingRepository).deleteById(training.getId());

    }
}
