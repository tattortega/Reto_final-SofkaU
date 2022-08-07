package co.com.sofka.usecase.rutaaprendizaje;

import co.com.sofka.model.rutaaprendizaje.RutaAprendizaje;
import co.com.sofka.model.rutaaprendizaje.gateways.RutaAprendizajeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RutaAprendizajeUseCase {

    private final RutaAprendizajeRepository rutaAprendizajeRepository;

    public Mono<RutaAprendizaje> crearRutaAprendizaje(RutaAprendizaje rutaAprendizaje) {
        return rutaAprendizajeRepository.save(rutaAprendizaje);
    }

    public Flux<RutaAprendizaje> listarRutaAprendizaje() {
        return rutaAprendizajeRepository.findAll();
    }

    public Mono<RutaAprendizaje> listarPorIdRutaAprendizaje(String id) {
        return rutaAprendizajeRepository.findById(id);
    }

    public Mono<RutaAprendizaje> actualizarRutaAprendizaje(String id, RutaAprendizaje rutaAprendizaje) {
        return rutaAprendizajeRepository.update(id, rutaAprendizaje);
    }

    public Mono<Void> eliminarRutaAprendizaje(String id) {
        return rutaAprendizajeRepository.deleteById(id);
    }
}
