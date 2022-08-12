package co.com.sofka.usecase.learningroute.getalllearningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Caso de uso GetAllLearningRoute
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllLearningRouteUseCase implements Supplier<Flux<LearningRoute>> {

    private final LearningRouteRepository learningRouteRepository;

    @Override
    public Flux<LearningRoute> get() {
        return learningRouteRepository.findAll();
    }
}
