package stepdefinitions;

import com.github.javafaker.Faker;
import context.ScenarioContext;
import models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class UserApiSteps {

    private final ScenarioContext scenarioContext;

    @Value("${api.baseUrl}")
    private String baseUrl;

    private final Faker faker = new Faker();
    private Response response;

    @Given("a user with random data exists")
    public void aUserWithRandomDataExists() {
        User user = User.builder()
                .id(faker.number().randomNumber())
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.phoneNumber().phoneNumber())
                .userStatus(1)
                .build();

        scenarioContext.setCreatedUser(user);
    }

    @When("the user is created via POST request")
    public void theUserIsCreatedViaPostRequest() {
        RestAssured.baseURI = baseUrl;

        response = given()
                .contentType("application/json")
                .body(scenarioContext.getCreatedUser())
                .when()
                .post("/user");
    }

    @Then("the creation should be successful")
    public void theCreationShouldBeSuccessful() {
        assertEquals(200, response.getStatusCode());
    }

    @When("the user is retrieved via GET request by username")
    public void theUserIsRetrievedViaGetRequestByUsername() {
        String username = scenarioContext.getCreatedUser().getUsername();

        Response getResponse = given()
                .when()
                .get("/user/" + username);

        User retrievedUser = getResponse.as(User.class);
        scenarioContext.setRetrievedUser(retrievedUser);
    }

    @Then("the retrieved user should match the created user using SoftAssert")
    public void theRetrievedUserShouldMatchUsingSoftAssert() {
        User created = scenarioContext.getCreatedUser();
        User retrieved = scenarioContext.getRetrievedUser();

        org.assertj.core.api.SoftAssertions softly = new org.assertj.core.api.SoftAssertions();
        softly.assertThat(retrieved.getUsername()).isEqualTo(created.getUsername());
        softly.assertThat(retrieved.getFirstName()).isEqualTo(created.getFirstName());
        softly.assertThat(retrieved.getLastName()).isEqualTo(created.getLastName());
        softly.assertThat(retrieved.getEmail()).isEqualTo(created.getEmail());
        softly.assertAll();
    }

    @Then("the retrieved user should match the created user using RecursiveComparison")
    public void theRetrievedUserShouldMatchUsingRecursiveComparison() {
        org.assertj.core.api.Assertions.assertThat(scenarioContext.getRetrievedUser())
                .usingRecursiveComparison()
                .isEqualTo(scenarioContext.getCreatedUser());
    }
}