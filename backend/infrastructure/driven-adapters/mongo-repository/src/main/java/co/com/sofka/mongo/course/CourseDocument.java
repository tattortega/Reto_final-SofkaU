package co.com.sofka.mongo.course;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "courses")
public class CourseDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer approvalValue;
}
