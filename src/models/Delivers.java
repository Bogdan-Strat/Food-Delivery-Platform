package models;

import java.math.BigDecimal;
import java.util.Queue;

public class Delivers {
    protected String m_name;
    protected Integer m_x;
    protected Integer m_y;
    protected Boolean m_free;
    protected BigDecimal m_money;


    public Delivers(){
        m_name = "None";
    }
    public Delivers(String m_name, Integer m_x, Integer m_y) {
        this.m_name = m_name;
        this.m_x = m_x;
        this.m_y = m_y;
        m_free = Boolean.TRUE;
        m_money = new BigDecimal(0);
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
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

    public Boolean getM_free() {
        return m_free;
    }

    public void setM_free(Boolean m_free) {
        this.m_free = m_free;
    }

    public void addMoney(BigDecimal money){
        m_money.add(money);
    }

    public BigDecimal getM_money() {
        return m_money;
    }

    public void setM_money(BigDecimal m_money) {
        this.m_money = m_money;
    }

    @Override
    public String toString() {
        return "Delivers{" +
                "m_name='" + m_name + '\'' +
                ", m_x=" + m_x +
                ", m_y=" + m_y +
                ", m_free=" + m_free +
                ", m_money=" + m_money +
                '}';
    }
}
