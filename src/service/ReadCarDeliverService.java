package service;

import models.BikeDeliver;
import models.CarDeliver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReadCarDeliverService {
    private String mName;
    private Integer mX, mY;
    private BigDecimal mCommission;

    private List<CarDeliver> mCarDeliver;

    public ReadCarDeliverService(){
        mCarDeliver= new ArrayList<>();
    }

    public void read() throws Exception{
        File file = new File("/home/bogdan/IdeaProjects/Food Delivery Platform/src/files/CarDelivers.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line= " ";
        String[] tempArr;

        while((line = br.readLine()) != null){
            tempArr = line.split(",");

            mName = tempArr[0];
            mX = Integer.valueOf(tempArr[1]);
            mY = Integer.valueOf(tempArr[2]);
            mCommission = BigDecimal.valueOf(Long.parseLong(tempArr[3]));

            mCarDeliver.add(new CarDeliver(mName,mX, mY, mCommission));
        }
        br.close();
    }

    public List<CarDeliver> getmCarDelivers(){
        return mCarDeliver;
    }
}
