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
        Mono<Course> courseMono1 = Mono.just(course1);

        String courseNameUpdate = "Desarrollo web";
        String courseDescriptionUpdate = "Desarrollo web con enfasis a JS avanzado";
        Integer approvalValuesUpdate = 75;
        Course course1Update = new Course("1", courseNameUpdate, courseDescriptionUpdate, approvalValuesUpdate);
        Mono<Course> courseMono2 = Mono.just(course1Update);

        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(courseMono1);
        when(courseRepository.update(course1.getId(), course1Update)).thenReturn(courseMono2);


        StepVerifier.create(updateCourseUseCase.apply(course1.getId(), course1Update))
                .expectNextMatches(course -> {
                    assert course.getId().equals("1");
                    assert course.getName().equals(courseNameUpdate);
                    assert course.getDescription().equals(courseDescriptionUpdate);
                    assert course.getApprovalValue().equals(approvalValuesUpdate);
                    return true;
                })
                .verifyComplete();

    }
}