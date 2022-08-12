package co.com.sofka.training;

import co.com.sofka.model.training.Training;
import co.com.sofka.usecase.training.createtraining.CreateTrainingUseCase;
import co.com.sofka.usecase.training.deletetraining.DeleteTrainingUseCase;
import co.com.sofka.usecase.training.getalltraining.GetAllTrainingUseCase;
import co.com.sofka.usecase.training.gettraining.GetTrainingUseCase;
import co.com.sofka.usecase.training.updatetraining.UpdateTrainingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TrainingHandler {

    private final GetTrainingUseCase getTrainingUseCase;
    private final GetAllTrainingUseCase getAllTrainingUseCase;
    private final CreateTrainingUseCase createTrainingUseCase;
    private final UpdateTrainingUseCase updateTrainingUseCase;
    private final DeleteTrainingUseCase deleteTrainingUseCase;

    public Mono<ServerResponse> getTraining(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(getTrainingUseCase)
                .flatMap(training -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(training));
    }

    public Mono<ServerResponse> getAllTraining(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllTrainingUseCase.get(), Training.class));
    }

    public Mono<ServerResponse> createTraining(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Training.class)
                .flatMap(createTrainingUseCase)
                .flatMap(training -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(training));
    }

    public Mono<ServerResponse> updateTraining(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Training.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects -> updateTrainingUseCase.apply(objects.getT2(), objects.getT1()))
                .flatMap(training -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(training));
    }

    public Mono<ServerResponse> deleteTraining(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(deleteTrainingUseCase)
                .flatMap(training -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(training));
    }
}
