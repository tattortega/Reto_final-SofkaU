package co.com.sofka.course.api;

import co.com.sofka.model.course.Course;
import co.com.sofka.usecase.course.createcourse.CreateCourseUseCase;
import co.com.sofka.usecase.course.deletecourse.DeleteCourseUseCase;
import co.com.sofka.usecase.course.getallcourse.GetAllCourseUseCase;
import co.com.sofka.usecase.course.getcourse.GetCourseUseCase;
import co.com.sofka.usecase.course.updatecourse.UpdateCourseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Handler para implementar los casos de uso de curso
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class CourseHandler {

    private final GetCourseUseCase getCourseUseCase;
    private final GetAllCourseUseCase getAllCourseUseCase;
    private final CreateCourseUseCase createCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    public Mono<ServerResponse> getCourse(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(getCourseUseCase)
                .flatMap(course -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(course));
    }

    public Mono<ServerResponse> getAllCourse(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllCourseUseCase.get(), Course.class));
    }

    public Mono<ServerResponse> createCourse(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Course.class)
                .flatMap(createCourseUseCase)
                .flatMap(course -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(course));
    }

    public Mono<ServerResponse> updateCourse(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Course.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects -> updateCourseUseCase.apply(objects.getT2(), objects.getT1()))
                .flatMap(course -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(course));
    }

    public Mono<ServerResponse> deleteCourse(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(deleteCourseUseCase)
                .flatMap(course -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(course));
    }
}
