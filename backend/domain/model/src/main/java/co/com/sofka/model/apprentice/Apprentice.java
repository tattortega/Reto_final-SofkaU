package co.com.sofka.model.apprentice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se crea el modelo de Apprentice con sus atributos.
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Apprentice {
    private String id;
    private String name;
    private String lastname;
    private String city;
    private String gender;
    private String email;
    private Integer phoneNumber;
    private String photo;
    private Boolean bilingual;
}
