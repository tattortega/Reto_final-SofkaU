package co.com.sofka.usecase.training.deletetraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso eliminar training
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
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
