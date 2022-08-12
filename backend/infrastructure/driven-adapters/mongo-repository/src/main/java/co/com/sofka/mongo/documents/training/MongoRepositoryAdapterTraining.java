package co.com.sofka.mongo.documents.training;

import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterTraining extends AdapterOperations<Training, TrainingDocument, String, MongoDBRepositoryTraining>
        implements TrainingRepository {

    public MongoRepositoryAdapterTraining(MongoDBRepositoryTraining repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Training.class));
    }

    @Override
    public Mono<Training> update(String id, Training training) {
        training.setId(id);
        return repository
                .save(new TrainingDocument(training.getId(), training.getName(), training.getDescription(), training.getStartDate(), training.getEndDate(), training.getCoach(), training.getRouteLearning(), training.getApprentices()))
                .flatMap(element -> Mono.just(training));
    }
}
