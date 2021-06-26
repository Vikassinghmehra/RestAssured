package enums;

import base.BaseHelper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:59 AM
 */
@Slf4j
public enum URLMapper {

    BOOK("v2/book"),
    MOVIE("v2/movie"),
    QUOTE("v2/movie/%id/quote");

    private String url;
    URLMapper(String url){
        this.url=url;
    }

    public static String getURL(URLMapper urlEnum,Object... params){
        String baseURL= BaseHelper.properties.getProperty("baseURI");
        return String.format(baseURL + urlEnum.url ,params);
    }
}

