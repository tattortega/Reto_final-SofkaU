package co.com.sofka.usecase.apprentice.updateapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdateApprenticeUseCase implements BiFunction<String, Apprentice, Mono<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Mono<Apprentice> apply(String id, Apprentice apprentice) {
        return apprenticeRepository.update(id, apprentice);
    }
}
