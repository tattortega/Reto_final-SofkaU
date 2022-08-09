package co.com.sofka.usecase.course.updatecourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdateCourseUseCase implements BiFunction<String, Course, Mono<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Mono<Course> apply(String id, Course course) {
        return courseRepository.update(id, course);
    }
}
