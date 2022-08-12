package co.com.sofka.model.course.gateways;

import co.com.sofka.model.course.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz para el modelo curso con sus metodos
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface CourseRepository {

    Mono<Course> save(Course course);

    Flux<Course> findAll();

    Mono<Course> findById(String id);

    Mono<Course> update(String id, Course course);

    Mono<Void> deleteById(String id);
}
