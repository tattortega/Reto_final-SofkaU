package co.com.sofka.model.apprentice.gateways;

import co.com.sofka.model.apprentice.Apprentice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se crea la interfaz de Apprentice con sus metodos.
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface ApprenticeRepository {
    Mono<Apprentice> save(Apprentice apprentice);

    Flux<Apprentice> findAll();

    Mono<Apprentice> findById(String id);

    Mono<Apprentice> update(String id, Apprentice apprentice);

    Mono<Void> deleteById(String id);
}
