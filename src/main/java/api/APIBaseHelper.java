package api;

import enums.HttpMethod;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

/**
 * @author Vikas Mehra
 * @date 26/06/21 12:49 PM
 */
public class APIBaseHelper {

    public static String executeRequest(OneAPIRequestSpecification oneAPIRequestSpecification , HttpMethod requestType ){
        Response response;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        if (oneAPIRequestSpecification.getContentType() != null)
            requestSpecBuilder.setContentType(oneAPIRequestSpecification.getContentType().getType());

        if (oneAPIRequestSpecification.getFormParameters() != null)
            requestSpecBuilder.addFormParams(oneAPIRequestSpecification.getFormParameters());

        if (oneAPIRequestSpecification.getQueryParameters() != null)
            requestSpecBuilder.addQueryParams(oneAPIRequestSpecification.getQueryParameters());

        if (oneAPIRequestSpecification.getContentObject() != null)
            requestSpecBuilder.setBody(oneAPIRequestSpecification.getContentObject());

        if (oneAPIRequestSpecification.getHeaders() != null)
            requestSpecBuilder.addHeaders(oneAPIRequestSpecification.getHeaders());

        response = execute(oneAPIRequestSpecification.getUrl(), requestType, requestSpecBuilder.build());


        if (oneAPIRequestSpecification.getResponseCode() != 0) {
            Assert.assertNotNull(response, "Response is null");
            Assert.assertEquals(response.getStatusCode(), oneAPIRequestSpecification.getResponseCode(), "Status code not equal, response is " + response.getStatusLine() + ", Response is " + response.asString());
        }
        return response != null && response.getBody() != null ? response.getBody().asString() : null;
    }

    private static Response execute(String baseUrl, HttpMethod requestType, RequestSpecification specification) {
        Response response = null;
        try {
            switch (requestType) {
                case GET:
                    response = RestAssured.given().spec(specification).get(baseUrl);
                    break;

                case POST:
                    response = RestAssured.given().spec(specification).post(baseUrl);
                    break;

                case PUT:
                    response = RestAssured.given().spec(specification).put(baseUrl);
                    break;

                case PATCH:
                    response = RestAssured.given().spec(specification).patch(baseUrl);
                    break;

                case DELETE:
                    response = RestAssured.given().spec(specification).delete(baseUrl);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}
