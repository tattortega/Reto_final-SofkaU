package co.com.sofka.usecase.training.deletetraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteTrainingUseCase implements Function<String, Mono<Void>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Mono<Void> apply(String id) {
        return trainingRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontró el training")))
                .map(Training::getId)
                .flatMap(trainingRepository::deleteById);
    }
}
