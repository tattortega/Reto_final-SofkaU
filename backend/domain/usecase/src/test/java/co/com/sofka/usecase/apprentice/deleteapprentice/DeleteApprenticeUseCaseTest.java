package co.com.sofka.usecase.apprentice.deleteapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class DeleteApprenticeUseCaseTest {

    @InjectMocks
    DeleteApprenticeUseCase deleteApprenticeUseCase;

    @Mock
    ApprenticeRepository apprenticeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteApprenticeTest() {
        Apprentice apprentice = Apprentice.builder()
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

        when(apprenticeRepository.findById("1")).thenReturn(Mono.just(apprentice));
        when(apprenticeRepository.deleteById("1")).thenReturn(Mono.empty());

        StepVerifier.create(deleteApprenticeUseCase.apply("1"))
                .expectComplete()
                .verify();
    }
}