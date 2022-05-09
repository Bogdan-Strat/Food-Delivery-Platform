package service;

import models.Drinks;
import models.Food;
import models.Products;
import models.Venues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ReadVenuesService {
    private String mNameVenue, mNameDrink, mNmeFood;
    private Integer mX, mY, mPortions, mMl, mGrams, mPrice;

    private Map<Venues, List<Products>> mVenues;

    private Venues mVenue;

    public ReadVenuesService(){
        mVenues = new HashMap<>();
    }

    public void readVenues() throws Exception{
        File file = new File("/home/bogdan/IdeaProjects/Food Delivery Platform/src/files/Venues.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line= " ";
        String[] tempArr;

        while ((line = br.readLine()) != null){
            tempArr = line.split(",");

            if(Objects.equals(tempArr[0], "Venue")){
                mNameVenue = tempArr[1];
                mX = Integer.valueOf(tempArr[2]);
                mY = Integer.valueOf(tempArr[3]);

                List<Products> list = new ArrayList<>();
                mVenue = new Venues(mNameVenue, mX, mY);
                mVenues.put(mVenue, list);
            }
            else if(Objects.equals(tempArr[0], "Food")){
                mNmeFood = tempArr[1];
                mPortions = Integer.valueOf(tempArr[2]);
                mGrams = Integer.valueOf(tempArr[3]);
                mPrice = Integer.valueOf(tempArr[4]);

                mVenues.get(mVenue).add(new Food(mNmeFood, mPortions, mGrams, mPrice));

            }

            else if(Objects.equals(tempArr[0], "Drink")){
                mNameDrink = tempArr[1];
                mPortions = Integer.valueOf(tempArr[2]);
                mMl = Integer.valueOf(tempArr[3]);
                mPrice = Integer.valueOf(tempArr[4]);

                mVenues.get(mVenue).add(new Drinks(mNameDrink, mPortions, mMl, mPrice));
            }

        }
        br.close();
    }

    public Map<Venues, List<Products>> getVenues(){
        return mVenues;
    }
}
