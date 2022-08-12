package co.com.sofka.usecase.training.gettraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetTrainingUseCase implements Function<String, Mono<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Mono<Training> apply(String id) {
        return trainingRepository.findById(id);
    }
}
