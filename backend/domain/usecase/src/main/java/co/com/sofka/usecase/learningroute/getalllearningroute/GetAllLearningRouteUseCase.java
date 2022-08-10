package co.com.sofka.usecase.learningroute.getalllearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetAllLearningRouteUseCase implements Supplier<Flux<LearningRoute>> {

    private final LearningRouteRepository learningRouteRepository;

    @Override
    public Flux<LearningRoute> get() {
        return learningRouteRepository.findAll();
    }
}
