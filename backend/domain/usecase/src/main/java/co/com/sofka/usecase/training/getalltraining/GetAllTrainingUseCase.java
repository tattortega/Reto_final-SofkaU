package co.com.sofka.usecase.training.getalltraining;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetAllTrainingUseCase implements Supplier<Flux<Training>> {

    private final TrainingRepository trainingRepository;

    @Override
    public Flux<Training> get() {
        return trainingRepository.findAll();
    }
}
