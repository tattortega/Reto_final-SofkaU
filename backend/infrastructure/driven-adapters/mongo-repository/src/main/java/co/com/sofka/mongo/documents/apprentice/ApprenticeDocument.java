package co.com.sofka.mongo.documents.apprentice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
