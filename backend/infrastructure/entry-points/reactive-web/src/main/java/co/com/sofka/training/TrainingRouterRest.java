package co.com.sofka.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Rutas para el training
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Configuration
public class TrainingRouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerTrainingFunction(TrainingHandler trainingHandler) {
        return route(GET("/api/training"), trainingHandler::getAllTraining)
                .andRoute(POST("/api/training"), trainingHandler::createTraining)
                .andRoute(PUT("/api/training/{id}"), trainingHandler::updateTraining)
                .andRoute(DELETE("/api/training/{id}"), trainingHandler::deleteTraining)
                .and(route(GET("/api/training/{id}"), trainingHandler::getTraining));

    }
}
