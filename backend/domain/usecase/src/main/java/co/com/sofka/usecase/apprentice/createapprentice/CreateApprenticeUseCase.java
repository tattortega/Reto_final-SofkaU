package co.com.sofka.usecase.apprentice.createapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateApprenticeUseCase implements Function<Apprentice, Mono<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Mono<Apprentice> apply(Apprentice apprentice) {
        return apprenticeRepository.save(apprentice);
    }
}
