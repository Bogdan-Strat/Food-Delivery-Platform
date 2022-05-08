package models;

import java.util.List;

public class Orders {
    private static int count=0;
    private int m_id;
    private Users m_user;
    private Delivers m_deliver;
    private Venues m_venue;

    private Integer m_time;



    private List<Products> m_command;

    public Orders(Users user, Venues venue, List<Products> command){
        m_id=++count;
        m_user=user;
        m_venue=venue;
        m_command=command;

    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public Users getM_user() {
        return m_user;
    }

    public void setM_user(Users m_user) {
        this.m_user = m_user;
    }

    public Delivers getM_deliver() {
        return m_deliver;
    }

    public void setM_deliver(Delivers m_deliver) {
        this.m_deliver = m_deliver;
    }

    public Integer getM_time() {
        return m_time;
    }

    public Venues getM_venue() {
        return m_venue;
    }

    public void setM_venue(Venues m_venue) {
        this.m_venue = m_venue;
    }

    public void setM_time(Integer m_time) {
        this.m_time = m_time;
    }
}
