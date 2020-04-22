package hungry.travelersapp.hungry_travellers_app.CartData;

public class CartModel {

    private String name , imgUrl, description, price;

    public CartModel() {
    }

    public CartModel(String name, String imgUrl, String description, String price) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
