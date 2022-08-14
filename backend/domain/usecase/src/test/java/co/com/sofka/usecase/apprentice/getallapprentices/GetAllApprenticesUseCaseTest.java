package co.com.sofka.usecase.apprentice.getallapprentices;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class GetAllApprenticesUseCaseTest {

    @InjectMocks
    GetAllApprenticesUseCase getAllApprenticesUseCase;

    @Mock
    ApprenticeRepository apprenticeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllApprenticesTest() {
        Apprentice apprentice1 = Apprentice.builder()
                .id("1")
                .name("nombre")
                .lastname("lastname")
                .city("city")
                .gender("gender")
                .email("email")
                .phoneNumber(1234)
                .photo("photo.png")
                .bilingual(true)
                .build();

        Apprentice apprentice2 = Apprentice.builder()
                .id("2")
                .name("nombre2")
                .lastname("lastname")
                .city("city")
                .gender("gender")
                .email("email")
                .phoneNumber(1234)
                .photo("photo.png")
                .bilingual(true)
                .build();

        Flux<Apprentice> apprenticeFlux = Flux.just(apprentice1, apprentice2);

        when(apprenticeRepository.findAll()).thenReturn(apprenticeFlux);

        StepVerifier.create(getAllApprenticesUseCase.get())
                .expectNextCount(2)
                .expectComplete()
                .verify();

    }
}