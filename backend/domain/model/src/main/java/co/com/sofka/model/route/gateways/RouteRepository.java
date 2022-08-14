package co.com.sofka.model.route.gateways;

import co.com.sofka.model.route.Route;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Se crea la interfaz de Route con sus metodos.
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
public interface RouteRepository {

    Mono<Route> save(Route route);

    Flux<Route> findAll();

    Mono<Void> deleteById(String id);
}
