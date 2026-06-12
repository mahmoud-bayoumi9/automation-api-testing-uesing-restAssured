package automationExerciseProject.fakerGenerate;

import com.github.javafaker.Faker;
import automationExerciseProject.models.brand;

public class brandSteps {
    public  static brand returnBrand(){
        Faker faker = new Faker();
        String brand=faker.company().name();
        return new brand(brand);
    }
}
