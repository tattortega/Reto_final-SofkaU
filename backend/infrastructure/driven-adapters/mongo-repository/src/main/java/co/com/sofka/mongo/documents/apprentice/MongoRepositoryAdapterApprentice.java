package co.com.sofka.mongo.documents.apprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Repositorio para implementar metodos en mongo
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Repository
public class MongoRepositoryAdapterApprentice extends AdapterOperations<Apprentice, ApprenticeDocument, String, MongoDBRepositoryApprentice>
        implements ApprenticeRepository {

    public MongoRepositoryAdapterApprentice(MongoDBRepositoryApprentice repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Apprentice.class));
    }

    @Override
    public Mono<Apprentice> update(String id, Apprentice apprentice) {
        apprentice.setId(id);
        return repository
                .save(new ApprenticeDocument(apprentice.getId(), apprentice.getName(), apprentice.getLastname(),
                        apprentice.getCity(), apprentice.getGender(), apprentice.getEmail(), apprentice.getPhoneNumber(), apprentice.getPhoto(), apprentice.getBilingual()
                )).flatMap(element -> Mono.just(apprentice));
    }
}
