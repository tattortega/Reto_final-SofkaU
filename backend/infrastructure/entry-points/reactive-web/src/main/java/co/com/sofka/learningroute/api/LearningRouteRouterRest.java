package co.com.sofka.learningroute.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class LearningRouteRouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionRutaAprendizaje(LearningRouteHandler learningRouteHandler) {
        return route(POST("/api/ruta"), learningRouteHandler::createLearningRoute)
                .andRoute(GET("/api/ruta"), learningRouteHandler::getAllLearningRoute)
                .andRoute(GET("/api/ruta/{id}"), learningRouteHandler::getLearningRoute)
                .andRoute(PUT("/api/ruta/{id}"), learningRouteHandler::updateLearningRoute)
                .andRoute(DELETE("/api/ruta/{id}"), learningRouteHandler::deleteLearningRoute);
    }
}
