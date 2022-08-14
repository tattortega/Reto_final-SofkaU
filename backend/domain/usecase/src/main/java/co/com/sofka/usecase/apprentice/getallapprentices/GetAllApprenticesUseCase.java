package co.com.sofka.usecase.apprentice.getallapprentices;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * Caso de uso GetAllApprentices
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @author Santiago Ospina <santiago.m200@outlook.es>
 * @version 1.0.0 2022-08-12
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class GetAllApprenticesUseCase implements Supplier<Flux<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Flux<Apprentice> get() {
        return apprenticeRepository.findAll();
    }
}
