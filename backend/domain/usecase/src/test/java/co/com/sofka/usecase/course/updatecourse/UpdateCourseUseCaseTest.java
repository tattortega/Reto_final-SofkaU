package co.com.sofka.usecase.course.updatecourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateCourseUseCaseTest {

    @InjectMocks
    UpdateCourseUseCase updateCourseUseCase;

    @Mock
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        updateCourseUseCase = new UpdateCourseUseCase(courseRepository);
    }

    @Test
    void updateCourseTest() {
        String courseName = "Desarrollo web";
        String courseDescription = "Desarrollo web con enfasis a JS";
        Integer approvalValues = 60;
        Course course1 = new Course("1", courseName, courseDescription, approvalValues);
        Mono<Course> courseMono = Mono.just(course1);

        String courseNameUpdate = "Desarrollo web";
        String courseDescriptionUpdate = "Desarrollo web con enfasis a JS avanzado";
        Integer approvalValuesUpdate = 60;
        Course course1Update = new Course("1", courseNameUpdate, courseDescriptionUpdate, approvalValuesUpdate);


        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(courseMono);
        when(courseRepository.findById(course1.getId())).thenReturn(courseMono);


        StepVerifier.create(updateCourseUseCase.apply(course1.getId(), course1Update))
                .expectNextMatches(course -> {
                    assert course.getId().equals("1");
                    assert course.getName().equals(courseNameUpdate);
                    assert course.getDescription().equals(courseDescription);
                    assert course.getApprovalValue().equals(approvalValues);
                    return true;
                })
                .verifyComplete();

        verify(courseRepository).save(Mockito.any(Course.class));
    }
}