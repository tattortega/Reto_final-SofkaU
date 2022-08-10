package co.com.sofka.usecase.learningroute.createlearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateLearningRouteUseCase implements Function<LearningRoute, Mono<LearningRoute>> {

    private final LearningRouteRepository learningRouteRepository;

    @Override
    public Mono<LearningRoute> apply(LearningRoute learningRoute) {
        return learningRouteRepository.save(learningRoute);
    }
}
