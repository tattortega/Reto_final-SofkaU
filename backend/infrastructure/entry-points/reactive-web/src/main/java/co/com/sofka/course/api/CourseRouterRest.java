package co.com.sofka.course.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * Rutas para el curso
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Configuration
public class CourseRouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(CourseHandler courseHandler) {
        return route(GET("/api/course"), courseHandler::getAllCourse)
                .andRoute(POST("/api/course"), courseHandler::createCourse)
                .andRoute(PUT("/api/course/{id}"), courseHandler::updateCourse)
                .andRoute(DELETE("/api/course/{id}"), courseHandler::deleteCourse)
                .and(route(GET("/api/course/{id}"), courseHandler::getCourse));

    }
}
