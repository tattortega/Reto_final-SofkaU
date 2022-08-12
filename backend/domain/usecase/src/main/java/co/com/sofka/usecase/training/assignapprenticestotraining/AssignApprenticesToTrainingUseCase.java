package co.com.sofka.usecase.training.assignapprenticestotraining;

import co.com.sofka.model.apprentice.gateways.ApprenticeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignApprenticesToTrainingUseCase {

    private final ApprenticeRepository apprenticeRepository;
}
