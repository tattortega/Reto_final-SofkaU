package co.com.sofka.mongo.documents.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "courses")
public class CourseDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer approvalValue;
}
