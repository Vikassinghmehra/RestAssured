package apiTest;

import action.BookApiAction;
import action.MovieApiAction;
import base.BaseTest;
import dto.Books;
import enums.HttpMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AutomaticConversionOfObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vikas Mehra
 * @date 26/06/21 4:30 PM
 */
public class MovieAPITest extends BaseTest {
    Map<String, String> map;
    @BeforeClass
     public void createData() {
         map = new HashMap<String, String>();
    }
    @AfterMethod
    public void clearMap(){
        map.clear();
    }
    @Test(priority = 1)
    public void negativeCaseWithoutHeader(){

        String res=MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.GET,401);
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/401.json");
        Assert.assertEquals(res,s);
    }

    @Test(priority = 2)
    public void negativeCaseWithRandomAuthorizationToken(){
        map.put("Authorization","kjsdf5676jhjhavsd@#@!@");
        String res=MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.GET,401);
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/401.json");
        Assert.assertEquals(res,s);

    }

    @Test(priority = 3)
    public void negativeCaseWithSpaceInAuthorization(){
        map.put("Authorization"," ");
        String res=MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.GET,401);
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/401.json");
        Assert.assertEquals(res,s);
    }

    @Test(priority = 4)
    public void negativeCaseWithEmptyOrNullToken(){
        map.put("Authorization",null);
        String res=MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.GET,401);
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/401.json");
        Assert.assertEquals(res,s);
    }

    @Test(priority = 5)
    public void negativeCaseWithspecialCharacter(){
        map.put("Authorization","@#@!(*&^%^&*@");
        String res=MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.GET,401);
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/401.json");
        Assert.assertEquals(res,s);
    }

    @Test(priority = 6)
    public void negativeCaseWithRestMethodPOST(){
        map.put("Authorization","@#@!(*&^%^&*@");
        MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.POST,404);

    }
    @Test(priority = 7)
    public void negativeCaseWithRestMethodPUT(){
        map.put("Authorization","@#@!(*&^%^&*@");
        MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.PUT,404);

    }
    @Test(priority = 8)
    public void negativeCaseWithRestMethodDELETE(){
        map.put("Authorization","@#@!(*&^%^&*@");
        MovieApiAction.withDiffHeadersAndHttpMethods(map, HttpMethod.DELETE,404);

    }

    @Test(priority = 9)
    public void happyCaseForMovieAPIWithValidToken(){
        String res=MovieApiAction.withValidToken();
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/Movie.json");
        Assert.assertEquals(res,s);
    }


}
