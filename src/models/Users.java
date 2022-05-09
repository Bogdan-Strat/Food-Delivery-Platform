package models;

import java.util.List;

public class Users {
    private String m_name;
    private String m_password;
    private String m_email;
    //private List<String> addresses;
    private Integer m_x;
    private Integer m_y;

    private Venues m_onRestaurant;

    public Users(String m_name, String m_password, String m_email, Integer x, Integer y) {
        this.m_name = m_name;
        this.m_password = m_password;
        this.m_email = m_email;
        m_x = x;
        m_y = y;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
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

    public Venues getM_onRestaurant() {
        return m_onRestaurant;
    }

    public void setM_onRestaurant(Venues m_onRestaurant) {
        this.m_onRestaurant = m_onRestaurant;
    }

    @Override
    public String toString() {
        return "Users{" +
                "m_name='" + m_name + '\'' +
                ", m_password='" + m_password + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_x=" + m_x +
                ", m_y=" + m_y +
                ", m_onRestaurant=" + m_onRestaurant +
                '}';
    }
}
