package co.com.sofka.usecase.apprentice.getallapprentices;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetAllApprenticesUseCase implements Supplier<Flux<Apprentice>> {

    private final ApprenticeRepository apprenticeRepository;

    @Override
    public Flux<Apprentice> get() {
        return apprenticeRepository.findAll();
    }
}
