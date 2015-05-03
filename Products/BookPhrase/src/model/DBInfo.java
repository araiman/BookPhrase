package model;

import java.io.Serializable;

/**
 * Created by RyomaArai on 15/04/14.
 */
public class DBInfo implements Serializable {
    String url = "jdbc:mysql://localhost/book_phrase";
    String user = "bookphrauser";
    String password = "ryoma31133113";

    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }
}
