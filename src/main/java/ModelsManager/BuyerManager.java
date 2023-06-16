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

import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

public class BuyerManager {

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

    public void removeProduct(){
        int id = Consola.readInt("Ingrese el id del producto a eliminar:");
        Consola.readString("");
        if(searchProductById(id)){
            System.out.println("Producto encontrado!");
            String resp = Consola.readString("Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                productRepo.delete(id);
                System.out.println("El producto se ha eliminado exitosamente!");
            }

        }else{
            System.out.println("El producto no se encuentra registrado en el sistema!");
        }


    }



    public Boolean searchProductById(int id){
        boolean resp = false;
        List<Product> productList = productRepo.toList();

        for(Product product : productList){
            if(id == product.getIdProduct()){
                resp = true;
                break;
            }
        }
        return resp;

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


    public void modifyProduct(){

        int idProducto = Consola.readInt("Ingrese el id del producto que desea modificar:");
        Consola.readString("");
        //que puede modificar una empresa de sus propios productos?
        //la Marca, nombre del producto, precio, stock y descripcion
        String brand = Consola.readString("Ingrese la nueva marca del producto: ");
        String productName = Consola.readString("Ingrese el nuevo nombre del producto:");
        float price = Consola.readFloat("Ingrese el nuevo precio del producto:");
        int quantity = Consola.readInt("Ingrese el numero actual de stock:");
        Consola.readString("");
        String description = Consola.readString("Ingrese una nueva descripción:");


        Product product = new Product(idProducto, brand, productName, price, quantity, description);

        productRepo.modify(product);

        System.out.println("Producto modificado con exito!");

    }

}

