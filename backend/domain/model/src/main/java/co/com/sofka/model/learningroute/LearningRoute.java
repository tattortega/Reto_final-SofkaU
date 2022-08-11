package co.com.sofka.model.learningroute;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.route.Route;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LearningRoute {

    private String id;
    private String name;
    private String description;
    private List<Route> routes;

    @Override
    public String toString() {
        return "LearningRoute{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", routes=" + routes +
                '}';
    }
}
