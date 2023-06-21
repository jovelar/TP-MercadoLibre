package ModelsManager;
import javax.swing.JOptionPane;

import Enums.Province;
import Models.Administrator;
import Models.Buyer;
import Models.Enterprise;
import Models.Product;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.BuyerRepo;
import Tools.Console;
import Tools.Menu;
import Tools.Validations;

import java.text.DateFormat;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class BuyerManager {

    class Validation{
        public boolean validateDate(String date){
            boolean status=false;

            return status;
        }
    }

    BuyerRepo buyerRepo = new BuyerRepo();

    public void showBuyersList(){
        List<Buyer> buyersList = buyerRepo.toList();

        for(int i = 0; i < buyersList.size(); i++){
            System.out.println( "ID:" + buyersList.get(i).getIdUser() + ". " + buyersList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }
    public void addBuyer(){
        Buyer newBuyer = null;

        String resp = "si";
        while(resp.equals("si")){

            int idUser = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del Nuevo usuario:")); //se supone que tiene q ser asignado automaticamente
            String userName = Console.readString("Ingrese el nombre de usuario: ");
            String email = Validations.doUntilValidEmail(Console.readString("Ingrese la direccion de email : "));
            String password = Console.readString("Ingrese su contrasena:");
            String firstName = Validations.doUntilValidName(Console.readString("Ingrese su nombre:"));
            String surname =Validations.doUntilValidName(Console.readString("Ingrese el apellido"));
            int dni = Validations.doUntilValidDNI(Console.readInt("Ingrese su dni"));
            String birthDate =Validations.doUntilValidBirthDate(Console.readString("Ingrese su fecha de nacimiento"));
            int phoneNumber = Integer.valueOf((int) Validations.doUntilValidPhoneNumber(Console.readInt("Ingrese su numero de telfono")));
            String city = Console.readString("ingrese su ciudad");
            //Enum province=Console.readString("Ingrese la provincia");
            String adress = Console.readString("ingrese su domicilio");
            int postalCode=Validations.doUntilValidPostalCode(Console.readInt("ingrese su codigo postal"));

            newBuyer=new Buyer(idUser,
                    userName,
                    email,
                    password,
                    firstName,
                    surname,
                    dni,null,
                    phoneNumber,
                    true,
                    Province.BSAS,
                    city,
                    adress,
                    postalCode);



            //Menu.categoriesMenu();

            buyerRepo.add(newBuyer);
            System.out.println("Usuario agregado exitosamente!");

            resp = Console.readString("Desea seguir agregando usuarios? si/no");

        }
    }

    public void removeBuyer(){
        int id = Console.readInt("Ingrese el id del compador a eliminar:");
        if(searchUserById(id)){
            System.out.println("Comprador encontrado!");
            String resp = Console.readString("Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                buyerRepo.delete(id);
                System.out.println("El comprador se ha eliminado exitosamente!");
            }

        }else{
            System.out.println("El comprador no se encuentra registrado en el sistema!");
        }


    }

    public Boolean searchUserById(int id){
        boolean resp = false;
        List<Buyer> buyers = buyerRepo.toList(); //trae stream desde el JSON

        for(Buyer buyer : buyers){
            if(id ==buyer.getIdUser()){
                resp = true;
                break;
            }
        }
        return resp;

    }

    //Metodo nuevo -> By Ezequiel
    public boolean searchBuyerByUsername(String username){
        for(Buyer buyer : this.buyerRepo.toList()){
            if(buyer.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    //Metodo nuevo -> By Ezequiel
    public Buyer returnBuyerById(int id){
        Buyer buyerWanted = null;

        for(Buyer buyer : this.buyerRepo.toList()){
            if(buyer.getIdUser() == id){
                buyerWanted = buyer;
                break;
            }
        }
        return buyerWanted;
    }

    //Metodo nuevo -> By Ezequiel
    public Buyer returnBuyerByUsername(String username){
        Buyer buyerWanted = null;

        for(Buyer buyer : this.buyerRepo.toList()){
            if(buyer.getUsername().equals(username)){
                buyerWanted = buyer;
                break;
            }
        }
        return buyerWanted;
    }

    public void modifyUser(){

        int idBuyer= Console.readInt("Ingrese el id del usuario que desea modificar:");

        if(searchUserById(idBuyer)){
            String userName=Console.readString("Ingrese el nuevo nombre de usuario");
            String email=Console.readString("Ingrese el nuevo email");
            String password=Console.readString("Ingrese la nueva contrasena");
            String firstName=Console.readString("Ingrese el nuevo nombre");
            String surname=Console.readString("Ingrese el nuevo apellido");
            String birthDate=Console.readString("Ingrese la nueva fecha de nacimiento");
            int phoneNumber=Console.readInt("Ingrese el nuevo numero de telefono");
            boolean active=true;
            String province=Console.readString("Ingrese la nueva provincia");
            String city=Console.readString("Ingrese la nueva ciudad");
            String adress=Console.readString("Ingrese la nueva direccion");

            Buyer modifierUser=buyerRepo.toList().get(idBuyer);

            modifierUser.setUsername(userName);
            modifierUser.setEmail(email);
            modifierUser.setPassword(password);
            modifierUser.setFirstName(firstName);
            modifierUser.setSurname(surname);
            //modifierUser.setBirthDate(birthDate);
            modifierUser.setPhoneNumber(phoneNumber);
            //modifierUser.setProvince(province);
            modifierUser.setCity(city);
            modifierUser.setAddress(adress);

            buyerRepo.modify(modifierUser);

            System.out.println("Usuario modificado con exito!");





        }

    }

}

