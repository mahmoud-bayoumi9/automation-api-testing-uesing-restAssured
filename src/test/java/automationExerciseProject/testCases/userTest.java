package automationExerciseProject.testCases;

import automationExerciseProject.apiModel.apiCalls;
import automationExerciseProject.fakerGenerate.genaretedUser;
import automationExerciseProject.models.loginUser;
import automationExerciseProject.models.user;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.restassured.response.Response;
import jdk.jfr.Description;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
@Listeners({AllureListeners.class})
public class userTest {
    @AfterSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "70.0.3538.77").
                        put("os", System.getProperty("os.name"))
                        .put("URL", "http://testjs.site88.net")
                        .build());
    }
    @Test
    @Owner("Mahmoud")
    @Description("user should be able to register with valid data")
    public void userShouldRegister(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegister(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 201"));
    }
    @Test
    @Owner("Mahmod")
    @Description(" userShould Not Able To Register With User That Aready Registered")
    public void userShouldNotAbleToRegisterWithUserThatAreadyRegistered(){
        user user= genaretedUser.getRegisteredUser();
        Response res= apiCalls.userRegister(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString("\"message\": \"Email already exists!"));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Register Without Address1")
    public void userShouldNotAbleToRegisterWithoutAddress1(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegisterWithOutAddress1(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString("\"message\": \"Bad request, address1 parameter is missing in POST request."));
    }
    @Owner("Mahmoud")
    @Description("user Should Not Able To Register Without password")
    @Test
    public void userShouldNotAbleToRegisterWithEmptyPassword(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegisterWithOutPassword(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, password parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Register With Arabic characters in password")
    public void userShouldNotAbleToRegisterWithArabicCharactersInPassword(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegisterWithArabicCharactersInPassword(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 201"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, Password parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Register Without firstName")
    public void userShouldNotAbleToRegisterWithoutFirstName(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegisterWithOutFirtName(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, firstname parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Register Without lastName")
    public void userShouldNotAbleToRegisterWithoutLastName(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.userRegisterWithoutLastName(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, lastname parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("userShouldNotAbleToRegisterWithSpecialCharactersInPhoneNumber")
    public void userShouldNotAbleToRegisterWithSpecialCharactersInPhoneNumber(){
        user user= genaretedUser.generateRandomUser();
        Response res= apiCalls.mobileNumberWithSpecialCharacters(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 201"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, lastname parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Able To Login With Valid Data")
    public void userShouldAbleToLogin(){
        Response res= apiCalls.loginWithValidData();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 200"));
        assertThat(htmlBody,containsString
                ("\"message\": \"User exists"));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Login Without Email")
    public void userShouldNotAbleToLoginWithoutEmail(){
        Response res= apiCalls.loginWithoutEmail();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, email or password parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Login Without Password")
    public void userShouldNotAbleToLoginWithoutPassword(){
        Response res= apiCalls.loginWithoutPassword();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, email or password parameter is missing in POST request."));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should Not Able To Login With IncorrectPassword")
    public void userShouldNotAbleToLoginWithRegisterEmailAndIncorrectPassword(){
        Response res= apiCalls.loginWithRegisterEmailAndIncorrectPassword();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Bad request, email or password parameter is missing in POST request."));
    }
    @Test
    @Tag("userDetails")
    @Description("userShowDetailsUsingEmail")
//    @Step("get user details by{user.getEmail()")
    public void userShouldAbleToGetAccountDetails(){
        loginUser user=genaretedUser.getLoginUser();
        Response res= apiCalls.userShouldAbleToGetAccountDetailsByemail(user);
        String email=user.getEmail();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 200"));
//        assertThat(htmlBody,containsString
//                ("\"user.email\":" +email));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user should delete")
    public void userShouldAbleToDeleteUser(){
        loginUser user=genaretedUser.getLoginUser();
        Response res= apiCalls.deleteUser(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 200"));
        assertThat(htmlBody,containsString
                ("\"message\": \"Account deleted!"));

    }
    @Test
    @Owner("Mahmoud")
    @Description("user Should be able to update data")
    public void userShouldAbleToUpdateUser(){
        user user= genaretedUser.updateUser();
        Response res= apiCalls.updateUser(user);
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 200"));
        assertThat(htmlBody,containsString
                ("\"message\": \"User updated!"));
    }
}
