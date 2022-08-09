package co.com.sofka.usecase.course.deletecourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteCourseUseCaseTest {

    @InjectMocks
    DeleteCourseUseCase deleteCourseUseCase;

    @Mock
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        deleteCourseUseCase = new DeleteCourseUseCase(courseRepository);
    }

    @Test
    void deleteCourseTest() {
        String courseName = "Desarrollo web";
        String courseDescription = "Desarrollo web con enfasis a JS";
        Integer approvalValues = 60;
        Course course1 = new Course("1", courseName, courseDescription, approvalValues);
        Mono<Course> courseMono = Mono.just(course1);

        when(courseRepository.findById(course1.getId())).thenReturn(courseMono);
        when(courseRepository.deleteById(course1.getId())).thenReturn(Mono.empty());

        StepVerifier.create(deleteCourseUseCase.apply(course1.getId()))
                .verifyComplete();

        verify(courseRepository).deleteById(course1.getId());
    }
}