package co.com.sofka.api.course;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


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
