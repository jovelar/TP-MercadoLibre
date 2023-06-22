package ModelsManager;

import Models.Administrator;
import Models.Product;
import Models.SubModels.Card;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.SubModelsRepo.CardRepo;
import Tools.Console;
import Tools.Menu;

import java.util.ArrayList;
import java.util.List;

public final class CardManager {

    CardRepo cardRepo = new CardRepo();

    public void showCardsList(){
        List<Card> cardsList = cardRepo.toList();

        for(int i = 0; i < cardsList.size(); i++){
            System.out.println( "ID:" + cardsList.get(i).getIdPayMethod() + " ." + cardsList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void addCard(){
        Card card = null;

        String resp = "si";
        while(resp.equals("si")){
            int idPayMethod = Console.readInt("Ingrese el id de la tarjeta:"); //TODO asignacion automatica de id
            int idBuyer = Console.readInt("Ingrese su id de comprador"); //TODO hay que ver la forma de que se asigne y no le pida el id al comprador
            double availableMoney = Console.readDouble("Ingrese su dinero disponible:");
            long creditCardNumber = Console.readLong("Ingrese su numero de tarjeta:");
            String expiryDate = Console.readString("Ingrese la fecha de vencimiento de su tarjeta");
            int cvcCode = Console.readInt("Ingrese el código de seguridad de la tarjeta");

            card = new Card(idPayMethod, idBuyer, availableMoney, creditCardNumber, expiryDate, cvcCode);

            cardRepo.add(card);
            System.out.println("Tarjeta agregada exitosamente!");

            resp = Console.readString("Desea seguir agregando tarjetas? si/no");

        }
    }

    public void removeProduct(){
        int id = Console.readInt("Ingrese el id de la tarjeta a eliminar:");
        if(searchCardById(id)){
            System.out.println("Tarjeta encontrada!");
            String resp = Console.readString("Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                cardRepo.delete(id);
                System.out.println("La tarjeta se ha eliminado exitosamente!");
            }

        }else{
            System.out.println("La tarjeta no se encuentra registrada en el sistema!");
        }


    }

    public boolean searchCardById(int id){
        boolean resp = false;
        List<Card> cardList = cardRepo.toList();

        for(Card card : cardList){
            if(id == card.getIdPayMethod()){
                resp = true;
                break;
            }
        }
        return resp;
    }
    public List<Card>getCards(List<Integer>idCards){
        List<Card>userCards=new ArrayList<Card>(); //lista de salida
        List<Card>allCards=cardRepo.toList();
        for(int x=0;x<idCards.size();x++){
            for(int z=0;z<allCards.size();z++){
                if(idCards.get(x)==allCards.get(z).getIdPayMethod()){
                    userCards.add(allCards.get(z));
                }

            }
        }
        return userCards;
    }
    /*
    public boolean isValidCard(int idCard){
        boolean valid=false;
        List<Card>allcards=cardRepo.toList();
        for(int x=0;x<allcards.size();x++){
            if(allcards.get(x).getIdPayMethod()==idCard){
                valid=true;
            }
        }
        return valid;
    }*/
}
