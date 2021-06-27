package apiTest.E2ETest;

import action.MovieApiAction;
import base.BaseTest;
import org.json.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vikas Mehra
 * @date 26/06/21 6:25 PM
 */
public class E2EFlow extends BaseTest {
    List<String> list;
    List<String> list2;

    @Test(priority = 1)
    public void happyCaseForMovieAPIWithValidToken() throws JSONException, IOException, ParseException {
        List<String> expectedList= new ArrayList<String>();
        expectedList.add("5cd95395de30eff6ebccde56");
        list=MovieApiAction.getIDWithValidToken();
        Assert.assertEquals(list.get(0),expectedList.get(0));

    }

    @Test(dependsOnMethods = "happyCaseForMovieAPIWithValidToken")
    public void quoteFromMovieID( )
    {
        List<String> expectedList= new ArrayList<String>();
        expectedList.add("5cd96e05de30eff6ebcce7e9");
        //System.out.println(" ======================>>>>>>>>>>>>"+list.get(list.size()-1));
        list2=MovieApiAction.getQuoteForMovieID(list.get(list.size()-1));
        Assert.assertEquals(list2.get(0),expectedList.get(0));
    }



}
