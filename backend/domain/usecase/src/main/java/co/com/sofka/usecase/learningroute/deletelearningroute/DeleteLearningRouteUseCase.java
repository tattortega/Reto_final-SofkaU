package co.com.sofka.usecase.learningroute.deletelearningroute;

import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteLearningRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;

    public Mono<Void> deleteLearningRoute(String id) {
        return learningRouteRepository.deleteById(id);
    }
}
