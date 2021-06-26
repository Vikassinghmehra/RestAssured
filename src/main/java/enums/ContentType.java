package enums;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:52 AM
 */
public enum ContentType {
    FORM_URLENCODED("application/x-www-form-urlencoded"),
    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml"),
    NONE("none");

    String type;
    ContentType(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
