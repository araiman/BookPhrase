package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by RyomaArai on 15/03/29.
 */
public class Post implements Serializable{
    private int id;
    private String isbn;
    private int userId;
    private Date postDate;
    private String bookTitle;
    private String phrase;
    private int favoriteCount;

    public Post(){}

    public Post(int id, String isbn, String phrase)  {
        this.id = id;
        this.isbn = isbn;
        this.phrase = phrase;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn (String isbn) {
        this.isbn = isbn;
    }
    public String getPhrase () {
        return this.phrase;
    }
    public void setPhrase (String phrase) {
        this.phrase = phrase;
    }

}
