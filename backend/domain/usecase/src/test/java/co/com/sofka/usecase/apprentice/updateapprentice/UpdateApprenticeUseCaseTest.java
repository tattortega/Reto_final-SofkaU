package co.com.sofka.usecase.apprentice.updateapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class UpdateApprenticeUseCaseTest {

    @InjectMocks
    UpdateApprenticeUseCase updateApprenticeUseCase;

    @Mock
    ApprenticeRepository apprenticeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateApprenticeTest() {
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

        Apprentice apprenticeUpdate = Apprentice.builder()
                .id("1")
                .name("nombre update")
                .lastname("lastname update")
                .city("city update")
                .gender("gender update")
                .email("email update")
                .phoneNumber(1234)
                .photo("photo.png")
                .bilingual(true)
                .build();

        when(apprenticeRepository.save(apprentice)).thenReturn(Mono.just(apprentice));
        when(apprenticeRepository.update("1", apprenticeUpdate)).thenReturn(Mono.just(apprenticeUpdate));

        StepVerifier.create(updateApprenticeUseCase.apply("1", apprenticeUpdate))
                .assertNext(apprentice1 -> {
                    Assertions.assertEquals("1", apprentice1.getId());
                    Assertions.assertEquals("nombre update", apprentice1.getName());
                    Assertions.assertEquals("lastname update", apprentice1.getLastname());
                    Assertions.assertEquals("city update", apprentice1.getCity());
                    Assertions.assertEquals("gender update", apprentice1.getGender());
                    Assertions.assertEquals("email update", apprentice1.getEmail());
                    Assertions.assertEquals(1234, apprentice1.getPhoneNumber());
                    Assertions.assertEquals("photo.png", apprentice1.getPhoto());
                    Assertions.assertEquals(true, apprentice1.getBilingual());
                })
                .expectComplete()
                .verify();
    }
}