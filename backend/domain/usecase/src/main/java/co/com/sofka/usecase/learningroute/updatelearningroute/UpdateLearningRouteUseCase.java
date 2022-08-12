package co.com.sofka.usecase.learningroute.updatelearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * Caso de uso UpdateLearningRoute
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class UpdateLearningRouteUseCase implements BiFunction<String, LearningRoute, Mono<LearningRoute>> {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<LearningRoute> apply(String id, LearningRoute learningRoute) {
        return learningRouteRepository.update(id, learningRoute);
    }
}
