package co.com.sofka.model.apprentice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
