package co.com.sofka.usecase.apprentice.getapprentice;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Caso de uso GetApprentice
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetApprenticeUseCase implements Function<String, Mono<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Mono<Apprentice> apply(String id) {
        return apprenticeRepository.findById(id);
    }
}
