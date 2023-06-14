package ModelsManager;

import Models.Administrator;
import Models.SubModels.Card;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.SubModelsRepo.CardRepo;

import java.util.List;

public class CardManager {

    CardRepo cardRepo = new CardRepo();

    public void showCardsList(){
        List<Card> cardsList = cardRepo.toList();

        for(int i = 0; i < cardsList.size(); i++){
            System.out.println( "ID:" + cardsList.get(i).getIdPayMethod() + " ." + cardsList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

}
