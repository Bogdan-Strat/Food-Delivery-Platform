package service;

import models.Orders;
import models.Products;
import models.Users;
import models.Venues;

import java.util.*;

public class UserService {

    private Map<Users, List<List<Products>>> m_historyCommands;
    private Map<Users, List<Products>> m_basket;

    public UserService(){
        m_historyCommands=new HashMap<>();
        m_basket = new HashMap<>();
    }

    public void signUp(Users user){
        List<Products> basket = new ArrayList<>();
        List<List<Products>> history = new ArrayList<>();
        //history.add(basket);
        m_basket.put(user,basket);
        m_historyCommands.put(user, history);
    }

    public Users logIn(){
        System.out.print("Email: ");
        Scanner sc = new Scanner(System.in);
        String email =sc.next();

        Users user = identifyUserByEmail(email);
        if (user != null){
            System.out.println("Password: ");
            String password = sc.next();
            if(Objects.equals(password, user.getM_password())){
                System.out.println("Welcome " + user.getM_name());
                return user;
            }
            else{
                System.out.println("Password incorrect. Try to log in again.");
                return null;
            }
        }
        else{
            System.out.println("Your email isn't in our database. TRy to Sign Up to our platform.");
            return null;
        }
    }
    public Users identifyUserByEmail(String email){
        for(Map.Entry<Users, List<Products>> entry : m_basket.entrySet()){
            if(Objects.equals(email, entry.getKey().getM_email())){
                return entry.getKey();
            }
        }
        return null;
    }

    public void selectRestaurant(Users user, Venues venues){
        //Users user = identifyUserByEmail(userEmail);
        user.setM_onRestaurant(venues);
    }
    public void showUsers(){
        for(Map.Entry<Users, List<Products>> entry : m_basket.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void addPoductInBasket(Users user, Products product){
        //Users user = identifyUserByEmail(userEmail);
        m_basket.get(user).add(product);
    }

    public void removeProductFromBasket(Users user, Products product){
        //Users user = identifyUserByEmail(userEmail);
        m_basket.get(user).remove(product);
    }

    public Orders placeOrder(Users user){
        //Users user = identifyUserByEmail(userEmail);
        List<Products> actual_basket = new ArrayList<>();
        //actual_basket = m_basket.get(user);

        for(Integer i=0; i<m_basket.get(user).size(); ++i){
            actual_basket.add(m_basket.get(user).get(i));
        }

        m_historyCommands.get(user).add(actual_basket);

        m_basket.get(user).clear();

        Orders order = new Orders(user, user.getM_onRestaurant(), actual_basket);


        return order;
    }

    public List<Products> getBasket(Users user){
        return m_basket.get(user);
    }

    public List<List<Products>> getHistory(Users user){
        return m_historyCommands.get(user);
    }

}
