package co.com.sofka.model.training.gateways;

import co.com.sofka.model.training.Training;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrainingRepository {

    Mono<Training> save(Training training);

    Flux<Training> findAll();

    Mono<Training> findById(String id);

    Mono<Training> update(String id, Training training);

    Mono<Void> deleteById(String id);
}
