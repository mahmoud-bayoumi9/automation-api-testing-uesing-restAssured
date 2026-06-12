package automationExerciseProject.testCases;

import automationExerciseProject.apiModel.apiCalls;
import automationExerciseProject.dataa.data;
import automationExerciseProject.fakerGenerate.ProductSteps;
import automationExerciseProject.models.Product;
import automationExerciseProject.models.errorMessage;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ProductsTest {
    @Test
    public void userToShouldReturnAllProduct(){
        Response res= apiCalls.getAllProducts();
        assertThat(res.statusCode(),equalTo(200));
    }

    @Test
    public void userAbleToAddProduct(){
        Product product= ProductSteps.generateRandomProduct();
       Response res= apiCalls.addProduct(product);
        errorMessage message=res.body().as(errorMessage.class);

        assertThat(message.getMessage(),equalTo(data.notSupported));
    }
    @Test
    public void searchProduct(){
        Response res= apiCalls.searchProduct(data.searchKeyword);
        assertThat(res.statusCode(),equalTo(200));
    }
    @Test
    public  void SearchProductwithoutsearch_productparameter(){
        Response res= apiCalls.searchWithoutSearchProduct();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
    }
}
