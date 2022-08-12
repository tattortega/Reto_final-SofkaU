package co.com.sofka.model.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo curso con sus atributos
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
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
