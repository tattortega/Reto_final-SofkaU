package co.com.sofka.rutaaprendizaje.api;

import co.com.sofka.model.rutaaprendizaje.RutaAprendizaje;
import co.com.sofka.usecase.rutaaprendizaje.RutaAprendizajeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerRutaAprendizaje {

    private final RutaAprendizajeUseCase rutaAprendizajeUseCase;

    public Mono<ServerResponse> crearRutaAprendizajeUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RutaAprendizaje.class)
                .flatMap(rutaAprendizaje -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(rutaAprendizajeUseCase.crearRutaAprendizaje(rutaAprendizaje), RutaAprendizaje.class));
    }

    public Mono<ServerResponse> listarRutaAprendizajeUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rutaAprendizajeUseCase.listarRutaAprendizaje(), RutaAprendizaje.class);
    }

    public Mono<ServerResponse> actualizarRutaAprendizajeUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(RutaAprendizaje.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(rutaAprendizajeUseCase.actualizarRutaAprendizaje(id, element), RutaAprendizaje.class));
    }

    public Mono<ServerResponse> eliminarRutaAprendizajeUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rutaAprendizajeUseCase.eliminarRutaAprendizaje(id), RutaAprendizaje.class);
    }
}
