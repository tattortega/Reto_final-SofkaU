package co.com.sofka.usecase.rutaaprendizaje;

import co.com.sofka.model.rutaaprendizaje.RutaAprendizaje;
import co.com.sofka.model.rutaaprendizaje.gateways.RutaAprendizajeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class CrearRutaAprendizajeUseCaseTest {

    @InjectMocks
    RutaAprendizajeUseCase rutaAprendizajeUseCase;

    @Mock
    RutaAprendizajeRepository rutaAprendizajeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRutaAprendizajeTest() {
        RutaAprendizaje rutaAprendizaje = RutaAprendizaje.builder()
                .id("1")
                .nombre("ruta 1")
                .descripcion("descripcion")
                .nivel(1)
                .prerrequisito("prerrequisito")
                .build();

        when(rutaAprendizajeRepository.findById("1")).thenReturn(Mono.just(rutaAprendizaje));

        StepVerifier.create(rutaAprendizajeUseCase.listarPorIdRutaAprendizaje("1"))
                .assertNext(ruta -> {
                    Assertions.assertEquals("1", ruta.getId());
                    Assertions.assertEquals("ruta 1", ruta.getNombre());
                    Assertions.assertEquals("descripcion", ruta.getDescripcion());
                    Assertions.assertEquals(1, ruta.getNivel());
                    Assertions.assertEquals("prerrequisito", ruta.getPrerrequisito());
                })
                .expectComplete()
                .verify();
    }
}