package co.com.sofka.usecase.course.getcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso obtener curso
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetCourseUseCase implements Function<String, Mono<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Mono<Course> apply(String id) {
        return courseRepository.findById(id);
    }
}
