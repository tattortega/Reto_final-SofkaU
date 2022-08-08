package co.com.sofka.usecase.learningroute.getalllearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetAllLearningRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;

    public Flux<LearningRoute> getAllLearningRoute() {
        return learningRouteRepository.findAll();
    }
}
