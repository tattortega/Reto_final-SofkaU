package co.com.sofka.model.rutaaprendizaje.gateways;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.rutaaprendizaje.RutaAprendizaje;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RutaAprendizajeRepository {

    Mono<RutaAprendizaje> save(RutaAprendizaje rutaAprendizaje);

    Flux<RutaAprendizaje> findAll();

    Mono<RutaAprendizaje> findById(String id);

    Mono<RutaAprendizaje> update(String id, RutaAprendizaje rutaAprendizaje);

    Mono<Void> deleteById(String id);
}
