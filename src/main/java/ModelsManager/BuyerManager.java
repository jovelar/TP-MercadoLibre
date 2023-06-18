package ModelsManager;
import javax.swing.JOptionPane;

import Enums.Province;
import Models.Administrator;
import Models.Buyer;
import Models.Product;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.BuyerRepo;
import Tools.Consola;
import Tools.Menu;

import java.text.DateFormat;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BuyerManager {

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

            int idUser = Consola.readInt("Ingrese el id del Nuevo usuario:"); //se supone que tiene q ser asignado automaticamente
            Consola.readString("");
            String userName = Consola.readString("Ingrese el nombre de usuario: ");
            Consola.readString("");
            String email = Consola.readString("Ingrese la direccion de email : ");
            String password = Consola.readString("Ingrese su contrasena:");
            String firstName = Consola.readString("Ingrese su nombre:");
            String surname=Consola.readString("Ingrese el apellido");
            int dni=Consola.readInt("Ingrese su dni");
            String birthDate=Consola.readString("Ingrese su fecha de nacimiento"); // REVISAR CON DATEBUILDER
            int phoneNumber=Consola.readInt("Ingrese su numero de telfono");
            String city=Consola.readString("ingrese su ciudad");
            //Enum province=Consola.readString("Ingrese la provincia");
            String adress=Consola.readString("ingrese su domicilio");
            int postalCode=Consola.readInt("ingrese su codigo postal");

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
            System.out.println("Producto agregado exitosamente!");

            resp = Consola.readString("Desea seguir agregando productos? si/no");

        }
    }

    public void removeBuyer(){
        int id = Consola.readInt("Ingrese el id del compador a eliminar:");
        Consola.readString("");
        if(searchUserById(id)){
            System.out.println("Comprador encontrado!");
            String resp = Consola.readString("Esta seguro de continuar? si/no");
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


    public void modifyUser(){

        int idBuyer= Consola.readInt("Ingrese el id del usuario que desea modificar:");

        if(searchUserById(idBuyer)){
            String userName=Consola.readString("Ingrese el nuevo nombre de usuario");
            String email=Consola.readString("Ingrese el nuevo email");
            String password=Consola.readString("Ingrese la nueva contrasena");
            String firstName=Consola.readString("Ingrese el nuevo nombre");
            String surname=Consola.readString("Ingrese el nuevo apellido");
            String birthDate=Consola.readString("Ingrese la nueva fecha de nacimiento");
            int phoneNumber=Consola.readInt("Ingrese el nuevo numero de telefono");
            boolean active=true;
            String province=Consola.readString("Ingrese la nueva provincia");
            String city=Consola.readString("Ingrese la nueva ciudad");
            String adress=Consola.readString("Ingrese la nueva direccion");

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

