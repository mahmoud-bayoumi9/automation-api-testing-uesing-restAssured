package automationExerciseProject.fakerGenerate;

import automationExerciseProject.models.Category;
import automationExerciseProject.models.Product;
import automationExerciseProject.models.Usertype;
import com.github.javafaker.Faker;
public class ProductSteps {

        public static Product generateRandomProduct() {
            Faker faker = new Faker();
            String randomUserType = faker.options().option("Women", "Men", "Kids", "Unisex");
            Usertype usertypeObj = new Usertype(randomUserType);
            String randomCategoryName = faker.options().option("Tops", "Dresses", "Jeans", "Shoes");
            Category categoryObj = new Category(usertypeObj, randomCategoryName);
            int randomId = faker.number().numberBetween(1, 1000);
            String randomProductName = faker.commerce().productName();
            String randomPrice = "Rs. " + faker.number().numberBetween(100, 2000);
            String randomBrand = faker.company().name();
            return new Product(randomId, randomProductName, randomPrice, randomBrand, categoryObj);
        }
    }

