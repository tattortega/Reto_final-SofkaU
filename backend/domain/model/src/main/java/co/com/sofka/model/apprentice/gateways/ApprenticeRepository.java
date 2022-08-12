package co.com.sofka.model.apprentice.gateways;

import co.com.sofka.model.apprentice.Apprentice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApprenticeRepository {
    Mono<Apprentice> save(Apprentice apprentice);

    Flux<Apprentice> findAll();

    Mono<Apprentice> findById(String id);

    Mono<Apprentice> update(String id, Apprentice apprentice);

    Mono<Void> deleteById(String id);
}
