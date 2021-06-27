package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author Vikas Mehra
 * @date 26/06/21 12:13 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Books {

    public Doc getDocs(int i) {
        return (Doc) docs[i];
    }



    public Map<String,String> docs[];
    public int total;
    public int limit;
    public int offset;
    public int page;
    public int pages;


}


