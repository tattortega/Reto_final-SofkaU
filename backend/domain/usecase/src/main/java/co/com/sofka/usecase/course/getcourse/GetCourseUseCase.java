package co.com.sofka.usecase.course.getcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetCourseUseCase implements Function<String, Mono<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Mono<Course> apply(String id) {
        return courseRepository.findById(id);
    }
}
