package co.com.sofka.usecase.apprentice.getapprentice;

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

class GetApprenticeUseCaseTest {

    @InjectMocks
    GetApprenticeUseCase getApprenticeUseCase;

    @Mock
    ApprenticeRepository apprenticeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getApprenticeTest() {
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

        StepVerifier.create(getApprenticeUseCase.apply("1"))
                .assertNext(apprentice1 -> {
                    Assertions.assertEquals("1", apprentice1.getId());
                    Assertions.assertEquals("nombre", apprentice1.getName());
                    Assertions.assertEquals("lastname", apprentice1.getLastname());
                    Assertions.assertEquals("city", apprentice1.getCity());
                    Assertions.assertEquals("gender", apprentice1.getGender());
                    Assertions.assertEquals("email", apprentice1.getEmail());
                    Assertions.assertEquals(1234, apprentice1.getPhoneNumber());
                    Assertions.assertEquals("photo.png", apprentice1.getPhoto());
                    Assertions.assertEquals(true, apprentice1.getBilingual());
                })
                .expectComplete()
                .verify();
    }
}