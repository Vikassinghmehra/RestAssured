package action;

import api.APIBaseHelper;
import api.OneAPIRequestSpecification;
import base.BaseHelper;
import dto.Books;
import enums.ContentType;
import enums.HttpMethod;
import enums.URLMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vikas Mehra
 * @date 26/06/21 4:29 PM
 */
public class MovieApiAction extends BaseHelper {



    public static String withDiffHeadersAndHttpMethods(Map<String,String> map,HttpMethod httpMethod,int responseCode) {
        OneAPIRequestSpecification requestSpecification = new OneAPIRequestSpecification
                (null,
                        ContentType.APPLICATION_JSON,
                        responseCode, URLMapper.getURL(URLMapper.MOVIE),
                        null, null, map);

        String response = APIBaseHelper.executeRequest(requestSpecification, httpMethod);

        //System.out.println(" Happy case ---------------------\n" + response);
        return  response;
    }

    public static String withValidToken() {
        Map<String,String>map=new HashMap<String, String>();
        map.put("Authorization","Bearer "+ properties.getProperty("token"));

        OneAPIRequestSpecification requestSpecification = new OneAPIRequestSpecification
                (null,
                        ContentType.APPLICATION_JSON,
                        200, URLMapper.getURL(URLMapper.MOVIE),
                        null, null, map);

        String response = APIBaseHelper.executeRequest(requestSpecification, HttpMethod.GET);

        System.out.println(" Happy case ---------------------\n" + response);

        return response;
    }


}
