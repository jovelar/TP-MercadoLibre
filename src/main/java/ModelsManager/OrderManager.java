package ModelsManager;

import Models.Buyer;
import Models.Product;
import Models.SubModels.Card;
import Models.SubModels.Order;
import Models.SubModels.PayMethod;
import ModelsRepo.SubModelsRepo.OrderRepo;
import Tools.Console;
import Tools.dateHandling;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class OrderManager {

    OrderRepo orderRepo = new OrderRepo();

    public void showOrdersList(){
        List<Order> orderList = orderRepo.toList();

        for(int i = 0; i < orderList.size(); i++){
            System.out.println( "ID:" + orderList.get(i).getIdOrder() + ". " + orderList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void showDeliveryDate(int idOrder){
        Order order = returnOrderById(idOrder);
        LocalDate deliveryDateLocalDate = dateHandling.convertStringToLocalDate(order.getDeliveryDate());
        System.out.print("El pedido se entregara el " + deliveryDateLocalDate.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"))+ " " + deliveryDateLocalDate.getDayOfMonth());
        System.out.print(" de " + deliveryDateLocalDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
    }

    /**
     * pago con tarjeta de credito/debito
     * @param buyer
     * @param productList
     * @return
     */
    public int addOrder(Buyer buyer, List<Product> productList,int pickedCard){
        Order order = null;

        int idOrder = orderRepo.toList().size()+1;
        int idBuyer = buyer.getIdUser();

        ArrayList<Product> solicitedProducts = returnListOfProductsByID(buyer.getCart(), productList); //Pasalos los productos del carrito al pedido

        //<PayMethod> payMethods = buyer.getPayMethod(); //TODO el comprador deberia elegir el metodo de pago
        //PayMethod chosenPaymentMethod = payMethods.get(2);//el metodo de pago de elegido se guarda en esta variable
        Card usedCard=new Card();
        usedCard.setIdPayMethod(pickedCard);
        PayMethod chosenPaymentMethod=new Card();
        String deliveryAddress = buyer.getAddress();


        LocalDate deliveryDateLocalDate = dateHandling.calculateDeliveryDate();
        String deliveryDate = dateHandling.convertLocalDateToString(deliveryDateLocalDate);

        order = new Order(idOrder, idBuyer, solicitedProducts, chosenPaymentMethod, deliveryAddress, deliveryDate);

        orderRepo.add(order);
        System.out.println("Pedido agregado exitosamente!");

        return order.getIdOrder();
    }

    /**
     * Pago con saldo cuenta propia.
     * @param buyer
     * @param productList
     * @return
     */
    public int addOrderCredit(Buyer buyer, List<Product> productList){
        Order order = null;

        int idOrder = orderRepo.toList().size()+1;
        int idBuyer = buyer.getIdUser();

        ArrayList<Product> solicitedProducts = returnListOfProductsByID(buyer.getCart(), productList); //Pasalos los productos del carrito al pedido

        //List<PayMethod> payMethods = buyer.getPayMethod(); //TODO el comprador deberia elegir el metodo de pago
        //PayMethod chosenPaymentMethod = payMethods.get(2);//el metodo de pago de elegido se guarda en esta variable
        String deliveryAddress = buyer.getAddress();


        LocalDate deliveryDateLocalDate = dateHandling.calculateDeliveryDate();
        String deliveryDate = dateHandling.convertLocalDateToString(deliveryDateLocalDate);

        order = new Order(idOrder, idBuyer, solicitedProducts, deliveryAddress, deliveryDate);

        orderRepo.add(order);
        System.out.println("Pedido agregado exitosamente!");

        return order.getIdOrder();
    }

    public ArrayList<Product> returnListOfProductsByID(ArrayList<Integer> productIdList, List<Product> productList){

        ArrayList<Product> solicitedProducts = new ArrayList<>();

        for( Integer id : productIdList){
            for(Product product : productList){
                if(id == product.getIdProduct()){
                    solicitedProducts.add(product);
                    break;
                }
            }

        }
        return solicitedProducts;
    }

    public void sendTheOrder(){
        int idOrder = Console.readInt("Ingrese el id del pedido a enviar:");
        if(searchOrderById(idOrder)){

            Console.showMessage("Pedido encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                Order order = returnOrderById(idOrder);
                order.setState(Order.OrderStatus.ON_THE_WAY); //ENTREGADO
                this.orderRepo.modify(order);
                Console.showMessage("¡Tu pedido está en camino!");
            }

        }else{
            Console.showMessage("¡El pedido no se encuentra registrado en el sistema!");
        }
    }

    public void deliverOrder(){
        int idOrder = Console.readInt("Ingrese el id del pedido a finalizar:");
        if(searchOrderById(idOrder)){

            Console.showMessage("Pedido encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                Order order = returnOrderById(idOrder);
                order.setState(Order.OrderStatus.DELIVERED); //ENTREGADO
                this.orderRepo.modify(order);
                Console.showMessage("¡El pedido se entregó exitosamente!");
            }

        }else{
            Console.showMessage("¡El pedido no se encuentra registrado en el sistema!");
        }
    }

    public void cancelOrder(){
        int idOrder = Console.readInt("Ingrese el id del pedido a cancelar:");
        if(searchOrderById(idOrder)){

            Console.showMessage("Pedido encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                Order order = returnOrderById(idOrder);
                order.setState(Order.OrderStatus.CANCELLED); //CANCELADO
                this.orderRepo.modify(order);
                Console.showMessage("¡El pedido se cancelo exitosamente!");
            }

        }else{
            Console.showMessage("¡El pedido no se encuentra registrado en el sistema!");
        }
    }

    public Order returnOrderById(int id){

        Order orderFound = null;

        for(Order order : orderRepo.toList()){
            if(id == order.getIdOrder()){
                orderFound = order;
                break;
            }
        }
        return orderFound;

    }


    public boolean searchOrderById(int id){
        boolean resp = false;
        List<Order> orderList = orderRepo.toList();

        for(Order order : orderList){
            if(id == order.getIdOrder()){
                resp = true;
                break;
            }
        }
        return resp;

    }


}
