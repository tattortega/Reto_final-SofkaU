package co.com.sofka.mongo.documents.training;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryTraining extends ReactiveMongoRepository<TrainingDocument, String>, ReactiveQueryByExampleExecutor<TrainingDocument> {
}
