package ModelsManager;

import Models.Administrator;
import Models.Product;
import ModelsRepo.AdministratorRepo;

import java.util.ArrayList;
import java.util.List;

public class AdmManager {

    AdministratorRepo administratorRepo = new AdministratorRepo();

    public void showAdministratorsList(){
        List<Administrator> admsList = administratorRepo.toList();

        for(int i = 0; i < admsList.size(); i++){
            System.out.println( "ID:" + admsList.get(i).getIdUser() + " ." + admsList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

}

