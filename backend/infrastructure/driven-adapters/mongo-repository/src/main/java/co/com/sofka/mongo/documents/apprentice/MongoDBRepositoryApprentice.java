package co.com.sofka.mongo.documents.apprentice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

/**
 * Interfaz de mongo reactivo para documento Apprentice
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface MongoDBRepositoryApprentice extends ReactiveMongoRepository<ApprenticeDocument, String>, ReactiveQueryByExampleExecutor<ApprenticeDocument> {
}
