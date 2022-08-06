package co.com.sofka.mongo.documents.rutaaprendizaje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutaAprendizajeDocument {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Integer nivel;
    //private Curso curso;
    private String prerrequisito;
}
