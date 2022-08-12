package co.com.sofka.mongo.documents.apprentice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryApprentice extends ReactiveMongoRepository<ApprenticeDocument, String>, ReactiveQueryByExampleExecutor<ApprenticeDocument> {
}
