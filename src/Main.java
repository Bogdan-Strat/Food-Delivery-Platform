import models.*;
import service.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        VenueService venueServcice = new VenueService();
        UserService userService = new UserService();
        DeliverService deliverService = new DeliverService();
        WriteAudit writeAudit = new WriteAudit();

        WriteAudit.openFile();
        //test reading for User
        ReadUserService readUserService = new ReadUserService();
        readUserService.read();


        for(Users user : readUserService.getUsers()){
            userService.signUp(user);
        }

        userService.showUsers();

        //test reading for bikeDeliver
        ReadBikeDeliverService readBikeDeliverService = new ReadBikeDeliverService();
        readBikeDeliverService.read();

        for(BikeDeliver bikeDeliver : readBikeDeliverService.getmBikeDelivers()){
            deliverService.addDeliver(bikeDeliver);
        }

        deliverService.showDelivers();

        //test for carDelivers
        ReadCarDeliverService readCarDeliverService = new ReadCarDeliverService();
        readCarDeliverService.read();

        for(CarDeliver carDeliver : readCarDeliverService.getmCarDelivers()){
            deliverService.addDeliver(carDeliver);
        }

        deliverService.showDelivers();

        //testing reading venues
        ReadVenuesService readVenuesService = new ReadVenuesService();
        readVenuesService.readVenues();

        System.out.println(readVenuesService.getVenues());
        for(Map.Entry<Venues, List<Products>> entry : readVenuesService.getVenues().entrySet()){
            venueServcice.addRestaurant(entry.getKey());
            for(Products product : entry.getValue()){
                venueServcice.addProductToMenu(entry.getKey(), product);
            }
        }

        venueServcice.showVenues();

        //making actions
        String userEmail = "aurel24@gmail.com";
        String venueName = "Kfc";
        String productName= "Cola";

        Venues venue = venueServcice.identifyVenueByName(venueName);

        Users user = userService.identifyUserByEmail(userEmail);

        user.setM_onRestaurant(venue);

       Products product = venueServcice.identifyProductFromMenuByName(venue, productName);

       userService.addPoductInBasket(user, product);

        System.out.println(userService.getBasket(user));


        Orders order1 = userService.placeOrder(user);
        Delivers deliver = deliverService.asigneeDeliver(order1);
        System.out.println(deliver.getM_x() + " " + deliver.getM_y());
        deliverService.takeOrder(deliver, order1);
        deliverService.deliverOrder(deliver, order1);
        deliverService.showDelivers();
        System.out.println(userService.getHistory(user));

        System.out.println("Welcome to my application.\n" +
                "The application ca respond just at this command:\n" +
                "LogIn ; HireBikeDriver ; HireCarDriver ;  AddMenu ; RemoveMenu ; CloseApplication");
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String line= " ";
        String[] tempArr;

        while((line = br.readLine()) != null){
            tempArr = line.split(" ");
            Users user1 ;
            Venues venue1;
            if(Objects.equals(tempArr[0], "LogIn")){
               user1 = userService.logIn();
               if(user1 != null){
                   writeAudit.writeInAudit("Login Succesfully made by the user with email address" + userEmail);
                   System.out.println("These are our restaurants:\n" + venueServcice.getRestaurants());
                   System.out.println("Use SelectRestaurant command and after it type the name of a restaurant to see the menu: ");
               }
               else{
                   writeAudit.writeInAudit("Login Failed");
               }
            }
            else if(Objects.equals(tempArr[0],"SelectRestaurant")){
                String restaurant ;
            }
        }
    }
}
