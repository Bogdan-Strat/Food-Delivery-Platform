package service;

import models.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadUserService {
    private String mName, mPassword, mEmail;
    private Integer mX, mY;

    private List<Users> mUsers;
    public ReadUserService(){
        mUsers = new ArrayList<>();
    }

    public void read() throws  Exception{
        File file = new File("/home/bogdan/IdeaProjects/Food Delivery Platform/src/files/Users.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        while ((line = br.readLine()) != null) {
            tempArr = line.split(",");

            mName = tempArr[0];
            mPassword = tempArr[1];
            mEmail = tempArr[2];
            mX = Integer.valueOf(tempArr[3]);
            mY = Integer.valueOf(tempArr[4]);

            mUsers.add(new Users(mName, mPassword, mEmail, mX, mY));
        }
        br.close();
    }

    public List<Users> getUsers(){
        return mUsers;
    }

}
