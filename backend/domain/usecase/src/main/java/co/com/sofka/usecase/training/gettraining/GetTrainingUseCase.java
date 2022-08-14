package co.com.sofka.usecase.training.gettraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso obtener training
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetTrainingUseCase implements Function<String, Mono<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Mono<Training> apply(String id) {
        return trainingRepository.findById(id);
    }
}
