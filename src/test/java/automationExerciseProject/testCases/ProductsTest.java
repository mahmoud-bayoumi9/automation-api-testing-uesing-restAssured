package automationExerciseProject.testCases;

import automationExerciseProject.apiModel.apiCalls;
import automationExerciseProject.dataa.data;
import automationExerciseProject.fakerGenerate.ProductSteps;
import automationExerciseProject.models.Product;
import automationExerciseProject.models.errorMessage;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
public class ProductsTest {
    @Test
    @Owner("Mahmoud")
    @Description("user should able to return all products")
    public void userToShouldReturnAllProduct(){
        Response res= apiCalls.getAllProducts();
        assertThat(res.statusCode(),equalTo(200));
    }

    @Test
    @Owner("Mahmoud")
    @Description("user should not able to add product ")
    public void userAbleToAddProduct(){
        Product product = ProductSteps.generateRandomProduct();
        Response res = apiCalls.addProduct(product);
        String htmlResponse = res.getBody().asString();
        String jsonBody = htmlResponse.substring(htmlResponse.indexOf("{"), htmlResponse.lastIndexOf("}") + 1);
        io.restassured.path.json.JsonPath jsonPath = new io.restassured.path.json.JsonPath(jsonBody);
        Assert.assertEquals(jsonPath.getInt("responseCode"), 405);
        String apiMessage = jsonPath.getString("message");
        assertThat(apiMessage, equalTo(data.notSupported));}
    @Test
    @Owner("Mahmoud")
 @Description("user should able to return specif   ic  product ")
    public void searchProduct(){
        Response res= apiCalls.searchProduct(data.searchKeyword);
        assertThat(res.statusCode(),equalTo(200));
    }
    @Test
    @Owner("Mahmoud")
    @Description("user should not able to return specif   ic  product without search keywod ")
    public  void SearchProductwithoutsearch_productparameter(){
        Response res= apiCalls.searchWithoutSearchProduct();
        String htmlBody=res.body().asString();
        assertThat(htmlBody,containsString("\"responseCode\": 400"));
    }
}
