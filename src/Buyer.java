import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends Client{
    private ArrayList<Order>orders;
    private ArrayList<Product>cart;
    private List<Product>favorites;
    private List<PayMethod>paymethod;

    //region constructors
    public Buyer(){

    }
    public Buyer(int iDPerson, int dni, String surname, String firstName, String username, String email,
                 String password, boolean active, long phoneNumber,LocalDateTime birthDate, Province province,
                 String city, String address, int postalCode, String type, ArrayList<Order> orders,
                 ArrayList<Product> cart, List<Product> favorites, List<PayMethod> paymethod) {

        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber, birthDate, province, city, address, postalCode, type);
        this.orders = orders;
        this.cart = cart;
        this.favorites = favorites;
        this.paymethod = paymethod;
    }

    //endregion

    //region getters and setters
    public void pay(){

    }
    public void cancelBuy(){

    }
    public void buyCart(){

    }
    public void instantBuy(){ //buy a product instantly

    }
    public void addFavorite(){

    }
    public void showFavoriteList(){

    }
    public void deleteFavorite(){

    }

    //endregion
}
