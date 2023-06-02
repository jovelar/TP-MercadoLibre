public class Client extends User {
    private Province province;
    private String city;
    private String adress;
    private int postalCode;
    private String type;

    public Client(){

    }
    public Client(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, Province province, String city, String adress, int postalCode, String type) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber);
        this.province = province;
        this.city = city;
        this.adress = adress;
        this.postalCode = postalCode;
        this.type = type;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
