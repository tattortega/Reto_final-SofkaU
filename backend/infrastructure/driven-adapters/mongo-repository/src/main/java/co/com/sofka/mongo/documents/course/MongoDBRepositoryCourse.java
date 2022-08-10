package co.com.sofka.mongo.documents.course;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryCourse extends ReactiveMongoRepository<CourseDocument, String>, ReactiveQueryByExampleExecutor<CourseDocument> {
}
