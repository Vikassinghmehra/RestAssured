package action;

import api.APIBaseHelper;
import api.OneAPIRequestSpecification;
import base.BaseHelper;
import enums.ContentType;
import enums.HttpMethod;
import enums.URLMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static List<String> getIDWithValidToken() {
        List<String> list=new ArrayList<String>();
        Map<String,String>map=new HashMap<String, String>();
        map.put("Authorization","Bearer "+ properties.getProperty("token"));

        OneAPIRequestSpecification requestSpecification = new OneAPIRequestSpecification
                (null,
                        ContentType.APPLICATION_JSON,
                        200, URLMapper.getURL(URLMapper.MOVIE),
                        null, null, map);

        String response = APIBaseHelper.executeRequest(requestSpecification, HttpMethod.GET);

        System.out.println(" Happy case ---------------------\n" + response);

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("docs");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsobj=jsonArray.getJSONObject(i);
                list.add((String) jsobj.get("_id"));
            }
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return list;
    }


    public static List<String> getQuoteForMovieID(String s){
        Map<String,String>map=new HashMap<String, String>();
        List<String> list=new ArrayList<String>();

        map.put("Authorization","Bearer "+ properties.getProperty("token"));

        OneAPIRequestSpecification requestSpecification = new OneAPIRequestSpecification
                (null,
                        ContentType.APPLICATION_JSON,
                        200, URLMapper.getURL(URLMapper.QUOTE,s),
                        null, null,map );
        String response = APIBaseHelper.executeRequest(requestSpecification, HttpMethod.GET);
        System.out.println("------------->"+response);

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("docs");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsobj=jsonArray.getJSONObject(i);
                list.add((String) jsobj.get("_id"));
            }
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return list;
    }

}
