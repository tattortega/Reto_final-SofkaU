package co.com.sofka.mongo.documents.training;

import co.com.sofka.model.apprentice.Apprentice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "trainings")
public class TrainingDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String coach;
    private String routeLearning;
    private List<Apprentice> apprentices;
}
