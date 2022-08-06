package co.com.sofka.rutaaprendizaje.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRestRutaAprendizaje {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(HandlerRutaAprendizaje handlerRutaAprendizaje) {
        return route(POST("/api/ruta/crear"), handlerRutaAprendizaje::crearRutaAprendizajeUseCase)
                .andRoute(GET("/api/ruta/listar"), handlerRutaAprendizaje::listarRutaAprendizajeUseCase)
                .andRoute(POST("/api/ruta/actualizar/{id}"), handlerRutaAprendizaje::actualizarRutaAprendizajeUseCase)
                .andRoute(DELETE("/api/ruta/eliminar/{id}"), handlerRutaAprendizaje::eliminarRutaAprendizajeUseCase);
    }
}
