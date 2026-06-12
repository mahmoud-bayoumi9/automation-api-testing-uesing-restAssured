package automationExerciseProject.fakerGenerate;

import com.github.javafaker.Faker;
import automationExerciseProject.apiModel.apiCalls;
import automationExerciseProject.models.loginUser;
import automationExerciseProject.models.user;

public class genaretedUser {
    public static user generateRandomUser() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
            String email = firstName.toLowerCase() + faker.number().numberBetween(10, 999) + "@example.com";
        String password = faker.internet().password(6, 12, true, true); // باسورود من 6 لـ 12 رقم وحرف
        String title = faker.options().option("Mr", "Mrs", "Miss");
        String birthDate = String.valueOf(faker.number().numberBetween(1, 28));
        String birthMonth = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        String birthYear = String.valueOf(faker.number().numberBetween(1980, 2005));
        String company = faker.company().name();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().buildingNumber() + " Floor";
        String country = faker.options().option("India", "United States", "Canada", "Australia", "New Zealand");
        String zipcode = faker.address().zipCode();
        String state = faker.address().state();
        String city = faker.address().city();
        String mobileNumber = faker.phoneNumber().cellPhone();
        return new user(
                fullName, email, password, title,
                birthDate, birthMonth, birthYear,
                firstName, lastName, company,
                address1, address2, country,
                zipcode, state, city, mobileNumber
        );
    }
    public static user getRegisteredUser(){
        user user= generateRandomUser();
        apiCalls.userRegister(user);
        return user;
    }
    public static loginUser getLoginUser(){
        user user= generateRandomUser();
        apiCalls.userRegister(user);
       return  new loginUser(user.getEmail(),user.getPassword());

    }
    public static user updateUser(){
        user user= generateRandomUser();
        apiCalls.userRegister(user);
        return user;

    }

}
