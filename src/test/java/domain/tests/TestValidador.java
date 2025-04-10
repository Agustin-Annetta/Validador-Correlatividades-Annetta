package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestValidador {
    private Alumno alumno1;
    private Materia algoritmos;
    private Materia disenioDeSistemas;
    private Materia paradigmas;
    @BeforeEach
    public void init() {
       alumno1 = new Alumno();
       alumno1.setNombre("Agustin Annetta");
       algoritmos = new Materia("Algoritmos", "k3700");
       disenioDeSistemas = new Materia("Diseño de Sistemas", "k3090");
       paradigmas = new Materia("Paradigmas de Programacion", "k5400");
       paradigmas.agregarCorrelativa(algoritmos);
       disenioDeSistemas.agregarCorrelativa(paradigmas, algoritmos);
    }
    @Test
    @DisplayName("La inscripción fue satisfactoria")
    public void inscripcionCorrectaTest() {
        alumno1.agregarMateriaAprobada(algoritmos);
        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(alummno1);
        unaInscripcion.anotarseA(disenioDeSistemas, paradigmas);
        Assertions.assertTrue(unaInscripcion.estaAprobada());
    }

    @Test
    @DisplayName("La inscripción no fue correcta")
    public void laInscripcionErroneaTest() {
        john.agregarMateriaAprobada(paradigmas);
        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(alumno1);
        unaInscripcion.anotarseA(disenioDeSistemas);
        Assertions.assertFalse(unaInscripcion.estaAprobada());
    }
}
