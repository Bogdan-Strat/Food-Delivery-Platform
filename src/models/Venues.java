package models;

import models.Products;

import java.util.HashMap;
import java.util.Map;

public class Venues {
    private String name;

    private Integer m_x;
    private Integer m_y;

    public Venues(){}
    public Venues(String name, Integer x, Integer y){
        this.name=name;
        m_x = x;
        m_y = y;
    }

    public Integer getM_x() {
        return m_x;
    }

    public void setM_x(Integer m_x) {
        this.m_x = m_x;
    }

    public Integer getM_y() {
        return m_y;
    }

    public void setM_y(Integer m_y) {
        this.m_y = m_y;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
