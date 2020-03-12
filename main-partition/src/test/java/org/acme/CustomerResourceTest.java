package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class CustomerResourceTest {
	@Test
	public void testList() {
		given()
				.when().get("/customer")
				.then()
				.statusCode(200)
				.body("$.size()", is(3),
						"name", containsInAnyOrder("Joe", "Jim", "Anna"));
	}
}
