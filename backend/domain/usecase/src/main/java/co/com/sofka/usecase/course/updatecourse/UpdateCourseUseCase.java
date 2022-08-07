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
        return courseRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontró el curso")))
                .map(course1 -> course1.toBuilder()
                        .name(course.getName())
                        .description(course.getDescription())
                        .approvalValue(course.getApprovalValue())
                        .build())
                .flatMap(courseRepository::save);
    }
}
