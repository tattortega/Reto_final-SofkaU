package co.com.sofka.model.training.gateways;

import co.com.sofka.model.training.Training;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz para el modelo training con sus metodos
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface TrainingRepository {

    Mono<Training> save(Training training);

    Flux<Training> findAll();

    Mono<Training> findById(String id);

    Mono<Training> update(String id, Training training);

    Mono<Void> deleteById(String id);
}
