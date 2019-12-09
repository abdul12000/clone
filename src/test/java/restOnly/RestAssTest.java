package restOnly;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class RestAssTest {


    @Test
        public void runTest(){
            HashMap<String, String> postContent = new HashMap<>();
            postContent.put("userId", "10101");
            postContent.put("title", "This is my title");
            postContent.put("body", "this is my bod");


            given().contentType(ContentType.JSON).
                    with().body(postContent).
                    when().post("https://jsonplaceholder.typicode.com/posts").
                    then().body("title", is("This is my title") ). body("body", is("this is my bod"));
    }

}
