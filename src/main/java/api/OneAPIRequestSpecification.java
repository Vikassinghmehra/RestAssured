package api;

import enums.ContentType;
import utils.AutomaticConversionOfObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vikas Mehra
 * @date 26/06/21 12:51 PM
 */
public class OneAPIRequestSpecification {

    Object contentObject;
    String url;
    ContentType contentType;
    int responseCode;
    Map<String,Object> formParameters;
    Map<String,Object> queryParameters;
    Map<String,String> headers;


    public OneAPIRequestSpecification(Object requestContent, ContentType contentType, int responseCode, String urlMapper, Object queryParameters, Object formParameters, Map<String, String> headers) {
        this.setContentType(contentType);
        this.setContentObject(requestContent);
        this.setResponseCode(responseCode);
        this.setUrl(urlMapper);
        this.setQueryParameters(queryParameters);
        this.setFormParameters(formParameters);
        this.setHeaders(headers);
    }


    public void setContentObject(Object contentObject) {
        this.contentObject = contentObject;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setFormParameters(Object formParameters) {
        if (formParameters instanceof Map)
            this.formParameters = (Map<String, Object>) formParameters;
        else
            this.formParameters = AutomaticConversionOfObjects.convertObjToMap(formParameters);
    }

    public void setQueryParameters(Object queryParameters) {
        if (queryParameters instanceof Map)
            this.queryParameters = (Map<String, Object>) queryParameters;
        else
            this.queryParameters = AutomaticConversionOfObjects.convertObjToMap(queryParameters);
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getContentObject() {
        return contentObject;
    }

    public String getUrl() {
        return url;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Map<String, Object> getFormParameters() {
        return formParameters;
    }

    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }


    public OneAPIRequestSpecification addHeaders(String key, String value) {
        if (headers == null || headers.isEmpty()) {
            headers = new HashMap<String,String>();
            headers.put("Accept", ContentType.APPLICATION_JSON.getType());
        }
        headers.put(key, value);
        return this;
    }

    public OneAPIRequestSpecification addQueryParams(String key, Object value) {
        if (queryParameters == null || queryParameters.isEmpty()) {
            queryParameters = new HashMap<String,Object>();
        }
        queryParameters.put(key, value);
        return this;
    }

    public OneAPIRequestSpecification addFormParams(String key, Object value) {
        if (formParameters == null || formParameters.isEmpty()) {
            formParameters = new HashMap<String, Object>();
        }
        formParameters.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return AutomaticConversionOfObjects.convertDTOToJson(this);
    }

}
