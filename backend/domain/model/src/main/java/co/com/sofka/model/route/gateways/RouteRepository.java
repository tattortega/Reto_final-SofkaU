package co.com.sofka.model.route.gateways;

import co.com.sofka.model.route.Route;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteRepository {

    Mono<Route> save(Route route);

    Flux<Route> findAll();

    Mono<Void> deleteById(String id);
}
