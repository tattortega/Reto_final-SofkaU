package co.com.sofka.mongo.documents.course;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Repositorio para implementar metodos en mongo
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Repository
public class MongoRepositoryAdapterCourse extends AdapterOperations<Course, CourseDocument, String, MongoDBRepositoryCourse>
        implements CourseRepository {

    public MongoRepositoryAdapterCourse(MongoDBRepositoryCourse repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Course.class));
    }

    @Override
    public Mono<Course> update(String id, Course course) {
        course.setId(id);
        return repository
                .save(new CourseDocument(course.getId(), course.getName(), course.getDescription(), course.getApprovalValue()))
                .flatMap(element -> Mono.just(course));
    }
}
