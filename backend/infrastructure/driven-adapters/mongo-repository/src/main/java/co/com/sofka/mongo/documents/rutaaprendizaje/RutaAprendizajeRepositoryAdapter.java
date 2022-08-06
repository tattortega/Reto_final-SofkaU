package co.com.sofka.mongo.documents.rutaaprendizaje;

import co.com.sofka.model.rutaaprendizaje.RutaAprendizaje;
import co.com.sofka.model.rutaaprendizaje.gateways.RutaAprendizajeRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class RutaAprendizajeRepositoryAdapter extends AdapterOperations<RutaAprendizaje, RutaAprendizajeDocument, String, RutaAprendizajeMongoDBRepository>
        implements RutaAprendizajeRepository {

    public RutaAprendizajeRepositoryAdapter(RutaAprendizajeMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, RutaAprendizaje.class));
    }

    @Override
    public Mono<RutaAprendizaje> update(String id, RutaAprendizaje rutaAprendizaje) {
        rutaAprendizaje.setId(id);
        return repository
                .save(new RutaAprendizajeDocument(rutaAprendizaje.getId(), rutaAprendizaje.getNombre(), rutaAprendizaje.getDescripcion(), rutaAprendizaje.getNivel(), rutaAprendizaje.getPrerrequisito()))
                .flatMap(element -> Mono.just(rutaAprendizaje));
    }
}
