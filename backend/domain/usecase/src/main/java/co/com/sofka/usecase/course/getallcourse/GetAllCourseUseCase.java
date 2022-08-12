package co.com.sofka.usecase.course.getallcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Caso de uso obtener todos los cursos
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllCourseUseCase implements Supplier<Flux<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Flux<Course> get() {
        return courseRepository.findAll();
    }
}
