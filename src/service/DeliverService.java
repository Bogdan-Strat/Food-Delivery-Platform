package service;

import com.sun.security.jgss.GSSUtil;
import models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DeliverService {
    private Map<Delivers, List<Orders>> m_orders;

    public DeliverService(){
        m_orders =  new HashMap<>();
    }

    public void addDeliver(Delivers deliver){
        List<Orders> orders = new ArrayList<>();
        m_orders.put(deliver, orders);
    }

    public Integer distance(Integer x1, Integer y1, Integer x2, Integer y2) {
        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);

    }

    public void takeOrder(Delivers deliver, Orders order){
        Integer deliver_x, deliver_y, venue_x, venue_y;

        deliver_x = deliver.getM_x();
        deliver_y = deliver.getM_y();
        venue_x = order.getM_venue().getM_x();
        venue_y = order.getM_venue().getM_y();

        increaseMoney(deliver, deliver_x, deliver_y, venue_x, venue_y);

        deliver.setM_x(order.getM_venue().getM_x());
        deliver.setM_y(order.getM_venue().getM_y());
        deliver.setM_free(Boolean.FALSE);
        m_orders.get(deliver).add(order);

    }

    public void deliverOrder(Delivers deliver, Orders order){
        Integer deliver_x, deliver_y, venue_x, venue_y;
        deliver_x = deliver.getM_x();
        deliver_y = deliver.getM_y();
        venue_x = order.getM_user().getM_x();
        venue_y = order.getM_user().getM_y();

        increaseMoney(deliver, deliver_x, deliver_y, venue_x, venue_y);

        deliver.setM_x(order.getM_user().getM_x());
        deliver.setM_y(order.getM_user().getM_y());

        deliver.setM_free(Boolean.TRUE);

    }

    public void increaseMoney(Delivers deliver, Integer deliver_x, Integer deliver_y, Integer venue_x, Integer venue_y) {
        Integer distance =  distance(deliver_x, deliver_y, venue_x, venue_y);

        if(deliver instanceof BikeDeliver)
        {   BigDecimal time;
            if(distance != 0){
              time = BigDecimal.valueOf(((CarDeliver) deliver).getM_speed()).divide(BigDecimal.valueOf(distance), 2);
            }
            else{
               time  = BigDecimal.valueOf(0);
            }

            BigDecimal money = time.multiply(BigDecimal.valueOf(0.8));
            money = money.add(deliver.getM_money());
            money = money.add(((BikeDeliver) deliver).getM_commission());
            deliver.setM_money(money);
        }

        else if(deliver instanceof CarDeliver){
            BigDecimal time;
            if(distance != 0){
                time = BigDecimal.valueOf(((CarDeliver) deliver).getM_speed()).divide(BigDecimal.valueOf(distance), 2);
            }
            else{
                time  = BigDecimal.valueOf(0);
            }
            BigDecimal money = time.multiply(BigDecimal.valueOf(1.2));
            money = money.add(deliver.getM_money());
            money = money.add(((CarDeliver) deliver).getM_commission());
            deliver.setM_money(money);
        }
    }

    public Delivers asigneeDeliver(Orders order){
        Integer order_x = order.getM_venue().getM_x();
        Integer order_y = order.getM_venue().getM_y();

        Integer deliver_x, deliver_y, distance_min=100000, distance;

        Delivers deliver = new Delivers();

        for(Map.Entry<Delivers, List<Orders>> entry : m_orders.entrySet()){
            if(entry.getKey().getM_free() == Boolean.TRUE){
                deliver_x = entry.getKey().getM_x();
                deliver_y = entry.getKey().getM_y();

                distance = (deliver_x - order_x) * (deliver_x - order_x) + (deliver_y - order_y) * (deliver_y - order_y);

                if(distance < distance_min){
                    distance_min =  distance;
                    deliver = entry.getKey();
                }
            }


        }

        if(deliver.getM_name() != "None"){
            order.setM_deliver(deliver);
            return deliver;
        }

        return null;

    }

    public void showDelivers(){
        for(Map.Entry<Delivers, List<Orders>> entry : m_orders.entrySet()){
            System.out.println(entry.getKey());
        }
    }

}
