package co.com.sofka.usecase.training.updatetraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * Caso de uso actualizar training
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class UpdateTrainingUseCase implements BiFunction<String, Training, Mono<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Mono<Training> apply(String id, Training training) {
        return trainingRepository.update(id, training);
    }
}
