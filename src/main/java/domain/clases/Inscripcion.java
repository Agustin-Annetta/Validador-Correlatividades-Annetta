package domain.clases;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Data
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion() {
        this.materias = new ArrayList<>();
    }

    public void inscribirseA(Materia ... materias) {
        Collections.addAll(this.materias, materias);
    }

    public boolean estaAprobada() {
        return this.materias.stream().allMatch(m -> this.alumno.cumpleCorrelatividad(m));
    }
}
