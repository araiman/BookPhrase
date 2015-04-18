package model;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class BookInfo {
    private String detailPageURL;
    private String imgAddress;
    private String isbn_str;

    public BookInfo() {
    }

    public BookInfo(String detailPageURL, String imgAddress, String isbn_str) {
        this.detailPageURL = detailPageURL;
        this.imgAddress = imgAddress;
        this.isbn_str = isbn_str;
    }

    public String getDetailPageURL() {
        return this.detailPageURL;
    }

    public void setDetailPageURL(String detailPageURL) {
        this.detailPageURL = detailPageURL;
    }

    public String getImgAddress() {
        return this.imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getIsbn_str() {
        return this.isbn_str;
    }

    public void setIsbn_str(String isbn_str) {
        this.isbn_str = isbn_str;
    }

}
