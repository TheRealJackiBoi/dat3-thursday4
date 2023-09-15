package dat3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GardenTask extends Task {

    private String gardenLocation;


    public GardenTask(String name, String description, LocalDate dueDate) {
        super(name, description, dueDate);
    }
}
