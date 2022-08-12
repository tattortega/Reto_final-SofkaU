package co.com.sofka.usecase.training.updatetraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdateTrainingUseCase implements BiFunction<String, Training, Mono<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Mono<Training> apply(String id, Training training) {
        return trainingRepository.update(id, training);
    }
}
