package co.com.sofka.mongo.documents.learningroute;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface LearningRouteMongoDBRepository extends ReactiveMongoRepository<LearningRouteDocument, String>,
        ReactiveQueryByExampleExecutor<LearningRouteDocument> {
}
