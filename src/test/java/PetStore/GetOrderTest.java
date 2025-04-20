package PetStore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetOrderTest extends BaseTest {

    @Test
    public void getOrderById() {
        int orderId = 1;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(orderId))
                .body("status", equalTo("placed"));
    }
}
