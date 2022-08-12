package co.com.sofka.model.learningroute.gateways;

import co.com.sofka.model.learningroute.LearningRoute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se crea la interfaz de LearningRoute con sus metodos.
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface LearningRouteRepository {

    Mono<LearningRoute> save(LearningRoute learningRoute);

    Flux<LearningRoute> findAll();

    Mono<LearningRoute> findById(String id);

    Mono<LearningRoute> update(String id, LearningRoute learningRoute);

    Mono<Void> deleteById(String id);
}
