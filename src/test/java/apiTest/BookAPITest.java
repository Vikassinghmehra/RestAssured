package apiTest;

import action.BookApiAction;
import base.BaseTest;
import dto.Books;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AutomaticConversionOfObjects;


public class BookAPITest extends BaseTest {


    @Test
    public void happyCaseRetrieveBooks(){
        Books book=BookApiAction.happyCaseRetreive3Books();
        String s=AutomaticConversionOfObjects.convertJsonFileToString(System.getProperty("user.dir")+"/src/test/java/ExpectedJson/Books.json");
        Assert.assertEquals(AutomaticConversionOfObjects.convertObjectToJson(book),s);

    }

}
