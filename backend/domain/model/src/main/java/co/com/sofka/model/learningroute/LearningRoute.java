package co.com.sofka.model.learningroute;

import co.com.sofka.model.route.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Se crea el modelo de LearningRoute con sus atributos.
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
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
