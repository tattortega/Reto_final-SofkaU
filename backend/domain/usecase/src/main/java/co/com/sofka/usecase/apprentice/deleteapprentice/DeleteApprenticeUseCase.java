package co.com.sofka.usecase.apprentice.deleteapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso DeleteApprentice
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
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
