package Step_definitions;

import com.jayway.jsonpath.DocumentContext;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import utilities.RequestBodyServices;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class socialNetworkingStepDep extends BaseSteps implements En {
    Response responseForGetPostRequest, responseForServiceTest, responseForPostRequest;
    RequestBodyServices requestBodyServices;
    DocumentContext requestBody;

    public socialNetworkingStepDep() {

        Given("^service is up and running$", () -> {
            setHeadersWithContentType();
            setEndpointPath(serviceUrl);
            getCall();
            responseForServiceTest = getResponse();
            assertThat(responseForServiceTest.statusCode(), is(200));

        });

        When("^i search for \"([^\"]*)\" of a post with a GET method$", (String id) -> {
            setHeadersWithContentType();
            setEndpointPath(makeAPostEndpoint + id);
            getCall();
            responseForGetPostRequest = getResponse();

        });

        Then("^i should get the correct \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" returned with status code of (\\d+)$",
                (String id, String title, String body, Integer sCode) -> {
                    assertThat("checking status code", responseForGetPostRequest.statusCode(), is(sCode));
                    assertThat(responseForGetPostRequest.body().jsonPath().get("title"), is(title));
                });
        When("^i create a new post with the following details \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$",
                (String uId, String title, String body) -> {
                    requestBodyServices = new RequestBodyServices();
                    setHeadersWithContentType();
                    requestBody = loadJsonTemplate(MakeAPostPayload);
                    requestBodyServices.setRequestBodyForNewPost(requestBody, uId, title, body);
                    setEndpointPath(makeAPostEndpoint);
                    postCallWithjSonBody();
                    responseForPostRequest = getResponse();

                });
        Then("^I should get the correct \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" returned with a new ID in the response$",
                (String uId, String title, String body) -> {
MatcherAssert.assertThat(responseForPostRequest.statusCode(), Matchers.is(201));
            assertNotNull(responseForPostRequest.body().jsonPath().get("id").toString());
            MatcherAssert.assertThat(responseForPostRequest.body().jsonPath().get("userId").toString().contains(uId), Matchers.is(true));
        });
    }

}
