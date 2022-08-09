package co.com.sofka.usecase.course.getallcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetAllCourseUseCase implements Supplier<Flux<Course>> {

    private final CourseRepository courseRepository;

    @Override
    public Flux<Course> get() {
        return courseRepository.findAll();
    }
}
