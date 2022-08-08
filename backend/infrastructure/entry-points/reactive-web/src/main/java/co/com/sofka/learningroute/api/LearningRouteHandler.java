package co.com.sofka.learningroute.api;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.usecase.learningroute.createlearningroute.CreateLearningRouteUseCase;
import co.com.sofka.usecase.learningroute.deletelearningroute.DeleteLearningRouteUseCase;
import co.com.sofka.usecase.learningroute.getalllearningroute.GetAllLearningRouteUseCase;
import co.com.sofka.usecase.learningroute.getlearningroute.GetLearningRouteUseCase;
import co.com.sofka.usecase.learningroute.updatelearningroute.UpdateLearningRouteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LearningRouteHandler {

    private final CreateLearningRouteUseCase createLearningRouteUseCase;
    private final GetAllLearningRouteUseCase getAllLearningRouteUseCase;
    private final GetLearningRouteUseCase getLearningRouteUseCase;
    private final UpdateLearningRouteUseCase updateLearningRouteUseCase;
    private final DeleteLearningRouteUseCase deleteLearningRouteUseCase;

    public Mono<ServerResponse> createLearningRoute(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(LearningRoute.class)
                .flatMap(learningRoute -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createLearningRouteUseCase.createLearningRoute(learningRoute), LearningRoute.class));
    }

    public Mono<ServerResponse> getAllLearningRoute(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllLearningRouteUseCase.getAllLearningRoute(), LearningRoute.class);
    }

    public Mono<ServerResponse> getLearningRoute(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getLearningRouteUseCase.getLearningRoute(id), LearningRoute.class);
    }

    public Mono<ServerResponse> updateLearningRoute(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(LearningRoute.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateLearningRouteUseCase.updateLearningRoute(id, element), LearningRoute.class));
    }

    public Mono<ServerResponse> deleteLearningRoute(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteLearningRouteUseCase.deleteLearningRoute(id), LearningRoute.class);
    }
}
