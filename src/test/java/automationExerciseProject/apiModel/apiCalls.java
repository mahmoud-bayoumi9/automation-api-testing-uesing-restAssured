package automationExerciseProject.apiModel;

import automationExerciseProject.dataa.urls;
import automationExerciseProject.fakerGenerate.genaretedUser;
import automationExerciseProject.models.Product;
import automationExerciseProject.models.brand;
import automationExerciseProject.models.loginUser;
import automationExerciseProject.models.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;

public class apiCalls {
    
    public static Response getAllProducts() {
        return given()
                .filter(new AllureRestAssured()) 
                .baseUri(urls.baseUrl)
                .contentType(ContentType.JSON)
                .when().
                get(urls.getAllProducts)
                .then()
                .log().all().extract().response();
    }

    public static Response addProduct(Product product) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl)
                .contentType(ContentType.JSON).body(product)
                .when().
                post(urls.addproduct)
                .then()
                .log().all().extract().response();
    }

    public static Response getAllBrands() {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl)
                .contentType(ContentType.JSON)
                .when().
                get(urls.prandList)
                .then()
                .log().all().extract().response();
    }

    public static Response addBrand(brand brand) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl)
                .contentType(ContentType.JSON).body(brand)
                .when().
                post(urls.prandList)
                .then()
                .log().all().extract().response();
    }

    public static Response searchProduct(String searchKeyword) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).formParam("search_product", searchKeyword)
                .contentType("application/x-www-form-urlencoded")
                .when().
                post(urls.searchProduct)
                .then()
                .log().all().extract().response();
    }

    public static Response searchWithoutSearchProduct() {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl)
                .contentType(ContentType.JSON)
                .when().
                post(urls.searchProduct)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegister(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegisterWithOutAddress1(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegisterWithOutPassword(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegisterWithArabicCharactersInPassword(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", "محمود")
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegisterWithOutFirtName(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response userRegisterWithoutLastName(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response mobileNumberWithSpecialCharacters(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress1())
                .formParam("address2", user.getAddress2())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", "dddd4352")
                .when().
                post(urls.registerUrl)
                .then()
                .log().all().extract().response();
    }

    public static Response loginWithValidData() {
        loginUser user = genaretedUser.getLoginUser();
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .when().
                post(urls.login)
                .then()
                .log().all().extract().response();
    }

    public static Response loginWithoutEmail() {
        loginUser user = genaretedUser.getLoginUser();
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("password", user.getPassword())
                .when().
                post(urls.login)
                .then()
                .log().all().extract().response();
    }

    public static Response loginWithoutPassword() {
        loginUser user = genaretedUser.getLoginUser();
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("email", user.getEmail())
                .when().
                post(urls.login)
                .then()
                .log().all().extract().response();
    }

    public static Response loginWithRegisterEmailAndIncorrectPassword() {
        loginUser user = genaretedUser.getLoginUser();
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("email", user.getEmail())
                .formParam("password", "45df5433@ddf45")
                .when().
                post(urls.login)
                .then()
                .log().all().extract().response();
    }

    public static Response userShouldAbleToGetAccountDetailsByemail(loginUser user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("email", user.getEmail())
                .when().
                get(urls.userDetails)
                .then()
                .log().all().extract().response();
    }

    // 🎯 تم تعديل مسار الديليت مباشرة كـ String لضمان نجاح الـ Build
    public static Response deleteUser(loginUser user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType(ContentType.URLENC)
                .formParam("email", user.getEmail())
                .when().
                delete("/api/deleteAccount") 
                .then()
                .log().all().extract().response();
    }

    // 🎯 تم إضافة ميثود الـ Update الناقصة التي يستدعيها كلاس الـ Test
    public static Response updateUser(user user) {
        return given()
                .filter(new AllureRestAssured())
                .baseUri(urls.baseUrl).contentType("application/x-www-form-urlencoded")
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("firstname", user.getFirstname())
                .formParam("lastname", user.getLastname())
                .formParam("address1", user.getAddress1())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZipcode())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobileNumber())
                .when().
                put("/api/updateAccount") 
                .then()
                .log().all().extract().response();
    }
}
