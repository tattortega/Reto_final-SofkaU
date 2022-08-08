package co.com.sofka.model.learningroute.gateways;

import co.com.sofka.model.learningroute.LearningRoute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LearningRouteRepository {

    Mono<LearningRoute> save(LearningRoute learningRoute);

    Flux<LearningRoute> findAll();

    Mono<LearningRoute> findById(String id);

    Mono<LearningRoute> update(String id, LearningRoute learningRoute);

    Mono<Void> deleteById(String id);
}
