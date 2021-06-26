package action;

import api.APIBaseHelper;
import api.OneAPIRequestSpecification;
import base.BaseHelper;
import dto.Books;
import enums.ContentType;
import enums.HttpMethod;
import enums.URLMapper;
import utils.AutomaticConversionOfObjects;

import java.util.Properties;

/**
 * @author Vikas Mehra
 * @date 26/06/21 1:20 PM
 */
public class BookApiAction extends BaseHelper {


    public static Books happyCaseRetreive3Books(){
        OneAPIRequestSpecification requestSpecification=new OneAPIRequestSpecification
                (null,
                        ContentType.APPLICATION_JSON,
                        200, URLMapper.getURL(URLMapper.BOOK),
                        null,null,null);

        String response = APIBaseHelper.executeRequest(requestSpecification, HttpMethod.GET);

        System.out.println(" Happy case ---------------------\n"+response);
        return (Books) AutomaticConversionOfObjects.convertJsonToObject(response, Books.class);
    }



}
