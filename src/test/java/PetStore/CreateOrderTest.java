package PetStore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateOrderTest extends BaseTest {

    @Test
    public void placeOrderForPet() {
        String body = """
            {
              "id": 1,
              "petId": 12,
              "quantity": 1,
              "shipDate": "2025-04-20T07:12:50.597Z",
              "status": "placed",
              "complete": true
            }
            """;

        given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("status", equalTo("placed"));
    }
}
