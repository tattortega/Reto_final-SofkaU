package co.com.sofka.model.learningroute;

import co.com.sofka.model.course.Course;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LearningRoute {

    private String id;
    private String name;
    private String description;
    private Integer level;
    private Course course;
    private String prerequisite;

    @Override
    public String toString() {
        return "LearningRoute{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", course=" + course +
                ", prerequisite='" + prerequisite + '\'' +
                '}';
    }
}
