package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
    public List<Doc> docs;
    public int total;
    public int limit;
    public int offset;
    public int page;
    public int pages;
}
class Doc{
    public String _id;
    public String name;
}

