package co.com.sofka.usecase.learningroute.createlearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateLearningRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<LearningRoute> createLearningRoute(LearningRoute learningRoute) {
        return learningRouteRepository.save(learningRoute);
    }
}
