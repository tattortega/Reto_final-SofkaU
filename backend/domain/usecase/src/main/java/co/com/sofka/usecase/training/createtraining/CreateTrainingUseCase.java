package co.com.sofka.usecase.training.createtraining;

import co.com.sofka.model.apprentice.Apprentice;
import co.com.sofka.model.training.Training;
import co.com.sofka.model.training.gateways.TrainingRepository;
import co.com.sofka.usecase.apprentice.createapprentice.CreateApprenticeUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public class CreateTrainingUseCase implements Function<Training, Mono<Training>> {

    private final TrainingRepository trainingRepository;
    private final CreateApprenticeUseCase createApprenticeUseCase;

    @Override
    public Mono<Training> apply(Training training) {
        try {
            String[] vector;
            String lines = "";
            int nLines = 0;
            FileReader fileReader = new FileReader((File) training.getApprentices());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            while (bufferedReader.readLine() != null) {
                nLines++;
            }
            fileReader.close();
            Apprentice [] apprentices = new Apprentice[nLines];
            fileReader = new FileReader("C:\\prueba.txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((lines = bufferedReader.readLine()) != null) {
                vector = lines.split(";");
                Apprentice apprentice = new Apprentice(null, vector[0], vector[1], vector[2], vector[3],
                        vector[4], Integer.parseInt(vector[5]), vector[6], Boolean.parseBoolean(vector[7]));
                apprentices[i] = apprentice;
                createApprenticeUseCase.apply(apprentice).subscribe();
                System.out.println("aprendiz "+ apprentice);
                i++;
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("aprendices "+ Arrays.toString(Arrays.stream(apprentices).toArray()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Training training1 = new Training(training.getId(), training.getName(), training.getApprentices())
        return trainingRepository.save(training);
    }
}
