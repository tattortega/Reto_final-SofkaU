package co.com.sofka.mongo.documents.course;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

/**
 * Interfaz de mongo reactivo para documento curso
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface MongoDBRepositoryCourse extends ReactiveMongoRepository<CourseDocument, String>, ReactiveQueryByExampleExecutor<CourseDocument> {
}
