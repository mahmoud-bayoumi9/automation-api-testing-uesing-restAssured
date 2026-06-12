package automationExerciseProject.testCases;

import automationExerciseProject.apiModel.apiCalls;
import automationExerciseProject.fakerGenerate.brandSteps;
import automationExerciseProject.models.brand;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class brandTest {
    @Test
    public void getAllBrand(){
        Response res= apiCalls.getAllBrands();
        assertThat(res.statusCode(), equalTo(200));

    }
    @Test
    public void addBrand(){
        brand brand= brandSteps.returnBrand();
        Response res= apiCalls.addBrand(brand);
        assertThat(res.statusCode(),equalTo(200));
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 405"));
    }
}
