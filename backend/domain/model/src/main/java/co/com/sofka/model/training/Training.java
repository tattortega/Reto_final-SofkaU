package co.com.sofka.model.training;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.learningroute.LearningRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Training {
    private String id;
    private String name;
    private String description;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    private LocalDate endDate;
    private String coach;
    private LearningRoute learningRoute;
    private List<Apprentice> apprentices;
}
