package ModelsManager;

import Models.Enterprise;
import ModelsRepo.EnterpriseRepo;

import java.util.List;

public class EnterpriseManager {

    EnterpriseRepo enterpriseRepo = new EnterpriseRepo();

    public void showEnterprisesList(){

        List<Enterprise> enterprisesList = enterpriseRepo.toList();

        for(int i = 0; i < enterprisesList.size(); i++){
            System.out.println( "ID:" + enterprisesList.get(i).getIdUser() + ". " + enterprisesList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void terminateCompany(){
        //baja logica
    }

    public void deleteEnterprise(){

    }

}
