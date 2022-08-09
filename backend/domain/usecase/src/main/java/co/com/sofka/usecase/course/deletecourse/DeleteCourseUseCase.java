package co.com.sofka.usecase.course.deletecourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteCourseUseCase implements Function<String, Mono<Void>> {

    private final CourseRepository courseRepository;

    @Override
    public Mono<Void> apply(String id) {
        return courseRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontró el curso")))
                .map(Course::getId)
                .flatMap(courseRepository::deleteById);
    }
}
