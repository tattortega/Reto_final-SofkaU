package co.com.sofka.model.route;

import co.com.sofka.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    private Integer level;
    private Course courseId;
    private Course precourseId;
}

