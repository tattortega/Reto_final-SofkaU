package co.com.sofka.usecase.course.getallcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetAllCourseUseCaseTest {

    @InjectMocks
    GetAllCourseUseCase getAllCourseUseCase;

    @Mock
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        getAllCourseUseCase = new GetAllCourseUseCase(courseRepository);
    }

    @Test
    void getAllCourseTest() {
        Course course1 = new Course("1", "Desarrollo web", "Spring boot,MySQL,JS", 75);
        Course course2 = new Course("2", "Introduccion a Desarrollo de software", "Java,GIT,JS", 75);
        Course course3 = new Course("3", "DDD", "Modelamiento de dominio", 90);
        Flux<Course> courseFlux = Flux.just(course1, course2, course3);

        when(courseRepository.findAll()).thenReturn(courseFlux);

        StepVerifier.create(getAllCourseUseCase.get())
                .expectNextCount(3)
                .verifyComplete();

        verify(courseRepository).findAll();

    }
}