public class Enterprise extends Client {
    private String fantasyName;

    private float salesRevenue;

    public Enterprise(){

    }

    public Enterprise(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, Province province, String city, String adress, int postalCode, String type, String fantasyName, float salesRevenue) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber, province, city, adress, postalCode, type);
        this.fantasyName = fantasyName;
        this.salesRevenue = salesRevenue;
    }
    public void addProduct(){

    }
    public void editProduct(){

    }
    public void updateProduct(){

    }
    public void deleteProduct(){

    }
}
