package co.com.sofka.usecase.learningroute.deletelearningroute;

import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteLearningRouteUseCase implements Function<String, Mono<Void>> {

    private final LearningRouteRepository learningRouteRepository;

    @Override
    public Mono<Void> apply(String id) {
        return learningRouteRepository.deleteById(id);
    }
}
