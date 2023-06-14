package ModelsManager;

import Models.Buyer;
import Models.SubModels.Order;
import ModelsRepo.BuyerRepo;
import ModelsRepo.SubModelsRepo.OrderRepo;

import java.util.List;

public class OrderManager {

    OrderRepo orderRepo = new OrderRepo();

    public void showOrdersList(){
        List<Order> orderList = orderRepo.toList();

        for(int i = 0; i < orderList.size(); i++){
            System.out.println( "ID:" + orderList.get(i).getIdOrder() + ". " + orderList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

}
