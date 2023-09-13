import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestRequst {

	JSONObject req = new JSONObject();

	@Test
	void testOne() {
		// Response response = get("https://reqres.in/api/users?page=2");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode,200);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/users?page=2").
		then().
		  statusCode(200).
		log().all().body("data id",equalTo(7));

	}

	@Test
	void test_2() {
		// Response response = get("https://reqres.in/api/users/2");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode,200);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/users/2").
		then().
		  statusCode(200).
		 log().all().body("data id", equalTo(2));
	}

	@Test
	void test_3() {
		// Response response = get("https://reqres.in/api/users/23");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode,200);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/users/23").
		then().
		  statusCode(404).
		log().all().body("data id", equalTo(7));
	}

	@Test
	void test_4() {
		// Response response = get("https://reqres.in/api/unknown");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		 //int statusCode = response.getStatusCode();
		//Assert.assertEquals(statusCode,200);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/unknown").
		then().
		  statusCode(200).
		log().all().body("data id", equalTo(1));
	}

	@Test
	void test_Five() {
		// Response response = get("https://reqres.in/api/unknown/2");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode,200);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/unknown/2").
		then().
		  statusCode(200).
		log().all().body("data id", equalTo(7));
	}

	@Test
	void test_6() {
		// Response response = get("https://reqres.in/api/unknown/23");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode, 404);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/unknown/23").
		then().
		  statusCode(200).
		log().all().body("data id", equalTo(7));
	}

	void test_7() {
		// Response response = get("https://reqres.in/api/unknown/23");

		// System.out.print("Status code:" + response.getStatusCode());
		// System.out.print("Body:" + response.getBody());
		// System.out.print("Time:" + response.getTime());

		// int statusCode = response.getStatusCode();
		// Assert.assertEquals(statusCode, 404);

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		given().
		  get("https://reqres.in/api/users?delay=3").
		then().
		  statusCode(200).
		log().all().body("data id",equalTo(1));
	}

	// post req
	@Test
	void test_11() {

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		System.out.println(req.toJSONString());

		given().
		  body(req.toJSONString()).
		when().
		  post("https://reqres.in/api/users").
		then().statusCode(201).
		log().all().body("id", equalTo(6));

	}

	@Test
	void test_12() {

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		System.out.println(req.toJSONString());

		given().
		  body(req.toJSONString()).
		when().
		  post("https://reqres.in/api/register").
		then().
		  statusCode(201).log().all().
		 body("id", equalTo(4));
	}

	@Test
	void test_13() {

		req.put("name", "Gudani");
		req.put("job","Automation Engineer");

		System.out.println(req.toJSONString());

		given().
		body(req.toJSONString()).
		when().
		  post("https://reqres.in/api/users").
		then().
		  statusCode(400).log().all().
		 body("id", equalTo(6));
	}

	@Test
	void test_14() {

		req.put("name", "Gudani");
		req.put("job", "Automation Engineer");

		System.out.println(req.toJSONString());

		given().
		body(req.toJSONString()).
		when().
		  post("https://reqres.in/api/login").
		then().
		  statusCode(200).log().all().
		body("id", equalTo(7));
	}

	@Test
	void test_15() {

		req.put("name","Gudani");
		req.put("job","Automation Engineer");

		System.out.println(req.toJSONString());

		given().body(req.toJSONString()).
		when().
		  post("https://reqres.in/api/login").
		then().
		  statusCode(400).log().all().
		body("id", equalTo(7));

	}

	// putch req
	@Test
	void test_16() {

		given().header("content-Type", "application").
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all().
		body("data id", equalTo(2));
	}
	// put req
	@Test
	void test_17() {

		given().header("content-Type", "application").
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}

	// delete req
	@Test
	void test_18() {

		given().header("content-Type", "application").
		delete("https://reqres.in/api/users/2").
		then().statusCode(200).
				log().all();
	}
}
