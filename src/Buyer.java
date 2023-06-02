import java.util.ArrayList;
import java.util.List;

public class Buyer extends Client{
    private ArrayList<Order>orders;
    private ArrayList<Product>cart;
    private List<Product>favorites;
    private List<PayMethod>paymethod;

    public Buyer(){

    }
    public Buyer(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, Province province, String city, String adress, int postalCode, String type, ArrayList<Order> orders, ArrayList<Product> cart, List<Product> favorites, List<PayMethod> paymethod) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber, province, city, adress, postalCode, type);
        this.orders = orders;
        this.cart = cart;
        this.favorites = favorites;
        this.paymethod = paymethod;
    }
    public void pay(){

    }
    public void cancelBuy(){

    }
    public void buyCart(){

    }
    public void instantBuy(){

    }
    public void addFavorite(){

    }
    public void showFavoriteList(){

    }
    public void deleteFavorite(){

    }
}
