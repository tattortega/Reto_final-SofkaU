package co.com.sofka.usecase.training.getalltraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Caso de uso obtener todos los trainings
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllTrainingUseCase implements Supplier<Flux<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Flux<Training> get() {
        return trainingRepository.findAll();
    }
}
