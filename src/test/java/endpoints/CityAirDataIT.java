package endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;

import io.qameta.allure.restassured.AllureRestAssured;
import tech.grasshopper.allure.Author;
import tech.grasshopper.allure.Authors;
import tech.grasshopper.allure.Categories;
import tech.grasshopper.allure.Category;
import tech.grasshopper.allure.Device;
import tech.grasshopper.allure.Devices;

@Categories({ @Category("Cities") })
@Authors({ @Author("John") })
@Devices({ @Device("Computer") })
public class CityAirDataIT {

	private static final String token = "1a5d8f027e344fa191b88e966bdb5d4aa4853d4a";

	@Test
	@Categories({ @Category("Europe") })
	@Devices({ @Device("Mac"), @Device("Windows") })
	public void getLondonAirData() {
		given().param("token", token).filter(new AllureRestAssured()).cookie("Cookie 1", "cookie one")
				.cookie("Cookie 2", "cookie two").header("Header 1", "header 1").when()
				.get("https://api.waqi.info/feed/london/").then().statusCode(equalTo(200));
	}

	@Test
	@Categories({ @Category("Europe") })
	@Authors({ @Author("Jane") })
	@Devices({ @Device("Mac") })
	public void getMunichAirData() {
		given().param("token", token).filter(new AllureRestAssured()).cookie("Cookie 1", "cookie one")
				.cookie("Cookie 2", "cookie two").when().get("https://api.waqi.info/feed/munich/").then()
				.statusCode(equalTo(201));
	}

	@Test
	@Ignore
	@Categories({ @Category("Fictional") })
	@Authors({ @Author("Lewis") })
	@Devices({ @Device("Kindle") })
	public void getNarniaAirData() {
		given().param("token", token).filter(new AllureRestAssured()).when().get("https://api.waqi.info/feed/narnia/")
				.then().statusCode(equalTo(200));
	}
}
