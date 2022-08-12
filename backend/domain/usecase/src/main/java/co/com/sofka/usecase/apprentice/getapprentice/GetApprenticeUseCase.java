package co.com.sofka.usecase.apprentice.getapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetApprenticeUseCase implements Function<String, Mono<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Mono<Apprentice> apply(String id) {
        return apprenticeRepository.findById(id);
    }
}
