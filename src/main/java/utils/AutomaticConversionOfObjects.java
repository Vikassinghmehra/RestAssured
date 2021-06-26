package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:41 AM
 */
public class AutomaticConversionOfObjects {
    public static String convertObjectToJson(Object object){
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

    public static Map<String, Object> convertObjToMap(Object requestSpecification) {
        try {
            return new ObjectMapper().readValue(new Gson().toJson(requestSpecification), new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertJsonFileToString(String filePath){
        String s=null;
        try{
            s = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
            System.out.print(s);
        }catch(Exception e){
            System.out.println("File Not found in path "+ filePath);
            e.printStackTrace();
        }
        return s;
    }


}
