package co.com.sofka.mongo.documents.training;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

/**
 * Interfaz de mongo reactivo para documento training
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface MongoDBRepositoryTraining extends ReactiveMongoRepository<TrainingDocument, String>, ReactiveQueryByExampleExecutor<TrainingDocument> {
}
