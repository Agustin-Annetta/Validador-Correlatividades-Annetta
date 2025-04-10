package domain.clases;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Alumno {
    @Setter
    private String nombre;

    @Setter
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }
    public boolean estaAprobada(Materia unaMateria) {
        return this.materiasAprobadas.contains(unaMateria);
    }
    public void agregarMateriaAprobada(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }
    public boolean cumpleCorrelatividad(Materia unaMateria) {
        return unaMateria.getCorrelativas().stream().allMatch(this::estaAprobada);
    }
}

