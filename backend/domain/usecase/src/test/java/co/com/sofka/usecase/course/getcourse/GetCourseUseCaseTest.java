package co.com.sofka.usecase.course.getcourse;

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

class GetCourseUseCaseTest {

    @InjectMocks
    GetCourseUseCase getCourseUseCase;

    @Mock
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        getCourseUseCase = new GetCourseUseCase(courseRepository);
    }

    @Test
    void getCourseTest() {
        String courseName = "Desarrollo web";
        String courseDescription = "Desarrollo web con enfasis a JS";
        Integer approvalValues = 60;
        Course course1 = new Course("1", courseName, courseDescription, approvalValues);
        Mono<Course> courseMono = Mono.just(course1);

        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(courseMono);
        when(courseRepository.findById(course1.getId())).thenReturn(courseMono);

        StepVerifier.create(getCourseUseCase.apply(course1.getId()))
                .expectNextMatches(course -> {
                    assert course.getId().equals("1");
                    assert course.getName().equals(courseName);
                    assert course.getDescription().equals(courseDescription);
                    assert course.getApprovalValue().equals(approvalValues);
                    return true;
                })
                .verifyComplete();

        verify(courseRepository).findById(course1.getId());
    }
}