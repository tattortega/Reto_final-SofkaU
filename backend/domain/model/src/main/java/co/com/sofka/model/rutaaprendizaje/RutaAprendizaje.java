package co.com.sofka.model.rutaaprendizaje;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RutaAprendizaje {

    private String id;
    private String nombre;
    private String descripcion;
    private Integer nivel;
    //private Curso curso;
    private String prerrequisito;

    @Override
    public String toString() {
        return "RutaAprendizaje{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nivel=" + nivel +
                //", curso=" + curso +
                ", prerrequisito='" + prerrequisito + '\'' +
                '}';
    }
}
