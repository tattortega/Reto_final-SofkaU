package co.com.sofka.usecase.learningroute.deletelearningroute;

import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso DeleteLearningRoute
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class DeleteLearningRouteUseCase implements Function<String, Mono<Void>> {

    private final LearningRouteRepository learningRouteRepository;

    @Override
    public Mono<Void> apply(String id) {
        return learningRouteRepository.deleteById(id);
    }
}
