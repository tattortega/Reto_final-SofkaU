package co.com.sofka.usecase.route.addcoursetoroute;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.learningroute.LearningRoute;
import co.com.sofka.model.learningroute.gateways.LearningRouteRepository;
import co.com.sofka.model.route.Route;
import co.com.sofka.usecase.course.createcourse.CreateCourseUseCase;
import co.com.sofka.usecase.course.getallcourse.GetAllCourseUseCase;
import co.com.sofka.usecase.learningroute.getalllearningroute.GetAllLearningRouteUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class AddCourseToRouteUseCase {

    private final LearningRouteRepository learningRouteRepository;
    private final CreateCourseUseCase createCourseUseCase;

//    public Mono<Course> addCourseToRoute(String learningRouteId, Integer level, String courseId) {
//        return learningRouteRepository.findById(learningRouteId)
//                .flatMap(route -> {
//                    return createCourseUseCase.apply()
//                            .map(course -> {
//                                route.setRoutes((List<Route>) course);
//                                return route;
//                            });
//                })
//                .flatMap(learningRouteRepository::save);
//    }
}
