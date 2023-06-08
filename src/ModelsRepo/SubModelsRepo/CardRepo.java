package ModelsRepo.SubModelsRepo;

import ModelsRepo.IRepository;
import Models.SubModels.Card;

import java.util.ArrayList;

public class CardRepo implements IRepository {

    private ArrayList<Card> cardList;

    public CardRepo(){

    }

    public CardRepo(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
