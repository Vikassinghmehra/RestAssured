package apiTest;

import action.BookApiAction;
import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class BookAPITest extends BaseTest {



    @Test
    public void HappyCaseRetrieveBooks(){
        BookApiAction.happyCaseRetreive3Books();
    }




}
