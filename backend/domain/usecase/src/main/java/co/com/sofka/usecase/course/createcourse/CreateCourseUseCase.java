package co.com.sofka.usecase.course.createcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateCourseUseCase implements Function<Course, Mono<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Mono<Course> apply(Course course) {
        return courseRepository.save(course);
    }
}
