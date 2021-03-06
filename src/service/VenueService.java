package service;

import models.Products;
import models.Venues;

import java.util.*;


public class VenueService {

    private Map<Venues, List<Products>> m_restaurants;
//    private Map<Venues,ProductService> m_restaurants;       //here I need a map with restaurants and a lists of products as menu
//
    public VenueService(){
        m_restaurants=new HashMap<>();
   }

   public void addRestaurant(Venues venue){
        List<Products> list = new ArrayList<>();
        m_restaurants.put(venue,list);
   }
   public void addProductToMenu(Venues venue, Products product){
        m_restaurants.get(venue).add(product);
   }

   public Venues identifyVenueByName(String venueName){
        for(Map.Entry<Venues, List<Products>> entry : m_restaurants.entrySet()){
            if(Objects.equals(venueName, entry.getKey().getName())){
                return entry.getKey();
            }
        }
        return null;
   }

   public Products identifyProductFromMenuByName(Venues venue, String productName){
        for(Products product : m_restaurants.get(venue)){
            if(Objects.equals(productName, product.getName())){
                return product;
            }
        }
        return null;

   }
   public void deleteProductFromMenu(Venues venue, Products product){
        m_restaurants.get(venue).remove(product);
   }

   public List<Products> getMenuOfRestaurant(Venues venue){
        return m_restaurants.get(venue);
   }

    public Map<String, Integer> getMenuOfRestaurantDetails(Venues venue){
        List<Products> menu = m_restaurants.get(venue);
        Map<String, Integer> menu_details = new HashMap<>();
        for(Integer i=0; i<menu.size(); ++i){
            menu_details.put(menu.get(i).getName(), menu.get(i).getPrice());
        }
        return menu_details;
    }

   public List<Venues> getRestaurants(){
        List<Venues> restaurants = new ArrayList<>();
        for(Map.Entry<Venues, List<Products>> entry : m_restaurants.entrySet()){
            restaurants.add(entry.getKey());
        }

        return restaurants;
   }

    public List<String> getRestaurantsName(){
        List<String> restaurants = new ArrayList<>();
        for(Map.Entry<Venues, List<Products>> entry : m_restaurants.entrySet()){
            restaurants.add(entry.getKey().getName());
        }

        return restaurants;
    }

    public void showVenues(){
        for(Map.Entry<Venues, List<Products>> entry : m_restaurants.entrySet()){
            System.out.println(entry.getKey());
            for(Products product : entry.getValue()){
                System.out.println(product);
            }
        }
    }

}
