package co.com.sofka.mongo.documents.learningroute;

import co.com.sofka.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearningRouteDocument {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer level;
    private Course course;
    private String prerequisite;
}
