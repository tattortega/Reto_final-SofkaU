package co.com.sofka.usecase.apprentice.deleteapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteApprenticeUseCase implements Function<String, Mono<Void>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Mono<Void> apply(String id) {
        return apprenticeRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontró el aprendiz")))
                .map(Apprentice::getId)
                .flatMap(apprenticeRepository::deleteById);
    }
}
