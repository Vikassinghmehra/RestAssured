package dto;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Vikas Mehra
 * @date 26/06/21 11:43 PM
 */

public class Movie
{
    private List<Docs> docs;

    private int total;

    private int limit;

    private int offset;

    private int page;

    private int pages;

    public void setDocs(List<Docs> docs){
        this.docs = docs;
    }
    public List<Docs> getDocs(){
        return this.docs;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    public void setLimit(int limit){
        this.limit = limit;
    }
    public int getLimit(){
        return this.limit;
    }
    public void setOffset(int offset){
        this.offset = offset;
    }
    public int getOffset(){
        return this.offset;
    }
    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public int getPages(){
        return this.pages;
    }
}
