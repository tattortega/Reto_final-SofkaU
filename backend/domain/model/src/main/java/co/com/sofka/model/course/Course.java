package co.com.sofka.model.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Course {

    private String id;
    private String name;
    private String description;
    private Integer approvalValue;
}
