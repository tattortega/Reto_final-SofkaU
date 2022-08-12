package co.com.sofka.usecase.learningroute.getlearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso GetLearningRoute
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetLearningRouteUseCase implements Function<String, Mono<LearningRoute>> {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<LearningRoute> apply(String id) {
        return learningRouteRepository.findById(id);
    }
}
