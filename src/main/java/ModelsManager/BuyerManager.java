package ModelsManager;

import Models.Administrator;
import Models.Buyer;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.BuyerRepo;

import java.util.List;

public final class BuyerManager {

    BuyerRepo buyerRepo = new BuyerRepo();

    public void showBuyersList(){
        List<Buyer> buyersList = buyerRepo.toList();

        for(int i = 0; i < buyersList.size(); i++){
            System.out.println( "ID:" + buyersList.get(i).getIdUser() + ". " + buyersList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

}

