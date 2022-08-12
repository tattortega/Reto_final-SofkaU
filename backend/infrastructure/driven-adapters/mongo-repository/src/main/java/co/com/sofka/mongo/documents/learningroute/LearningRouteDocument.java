package co.com.sofka.mongo.documents.learningroute;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.route.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Documento LearningRoute
 *
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearningRouteDocument {

    @Id
    private String id;
    private String name;
    private String description;
    private ArrayList<Route> routes;
}
