package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.mapper.ObjectMapper;

import java.lang.reflect.Type;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:41 AM
 */
public class AutomaticConversionOfObjects {
    public static String convertDTOToJson(Object object){
        try{
            return new GsonBuilder().disableHtmlEscaping().create().toJson(object);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Object convertJsonToObject(String json, Type type){

        Object obj=null;
        try{
            obj=new Gson().fromJson(json,type);

        }catch(Exception e){
            System.out.println(json);
            e.printStackTrace();
        }
        return obj;
    }
}
