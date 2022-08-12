package co.com.sofka.mongo.documents.learningroute;

import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import co.com.sofka.model.route.Route;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 * Repositorio para implementar metodos en mongo
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Repository
public class LearningRouteRepositoryAdapter extends AdapterOperations<LearningRoute, LearningRouteDocument, String, LearningRouteMongoDBRepository>
        implements LearningRouteRepository {


    public LearningRouteRepositoryAdapter(LearningRouteMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, LearningRoute.class));
    }

    @Override
    public Mono<LearningRoute> update(String id, LearningRoute learningRoute) {
        learningRoute.setId(id);
        return repository
                .save(new LearningRouteDocument(learningRoute.getId(), learningRoute.getName(), learningRoute.getDescription(), (ArrayList<Route>) learningRoute.getRoutes()))
                .flatMap(element -> Mono.just(learningRoute));
    }
}
