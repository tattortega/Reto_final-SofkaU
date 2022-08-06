package co.com.sofka.mongo.documents.rutaaprendizaje;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface RutaAprendizajeMongoDBRepository extends ReactiveMongoRepository<RutaAprendizajeDocument, String>,
        ReactiveQueryByExampleExecutor<RutaAprendizajeDocument> {
}
