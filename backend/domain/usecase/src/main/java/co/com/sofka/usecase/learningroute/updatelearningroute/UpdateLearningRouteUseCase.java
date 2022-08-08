package co.com.sofka.usecase.learningroute.updatelearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateLearningRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<LearningRoute> updateLearningRoute(String id, LearningRoute learningRoute) {
        return learningRouteRepository.update(id, learningRoute);
    }
}
