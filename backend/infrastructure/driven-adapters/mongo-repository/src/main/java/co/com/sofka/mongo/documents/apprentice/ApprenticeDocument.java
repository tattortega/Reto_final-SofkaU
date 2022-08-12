package co.com.sofka.mongo.documents.apprentice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Documento Apprentice
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "apprentices")
public class ApprenticeDocument {
    @Id
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
