package co.com.sofka.usecase.learningroute.getlearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetLearningRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<LearningRoute> getLearningRoute(String id) {
        return learningRouteRepository.findById(id);
    }
}
