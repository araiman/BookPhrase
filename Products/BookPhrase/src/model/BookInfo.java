package model;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class BookInfo {
    // TODO imgAddressを単体の変数にするか、配列にするかを確定させる
    private String imgAddress;
    private String merchandiseAddress;

    BookInfo() {
    }

    BookInfo(String imgAddress, String merchandiseAddress) {
        this.imgAddress = imgAddress;
        this.merchandiseAddress = merchandiseAddress;
    }

    public String getImgAddress() {
        return this.imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getMerchandiseAddress() {
        return this.merchandiseAddress;
    }

    public void setMerchandiseAddress(String merchandiseAddress) {
        this.merchandiseAddress = merchandiseAddress;
    }
}
