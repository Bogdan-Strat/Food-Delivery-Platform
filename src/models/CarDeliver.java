package models;

import java.math.BigDecimal;

public class CarDeliver extends Delivers{
    private BigDecimal m_commission;

    private Integer m_speed = 40;

    public CarDeliver(String m_name, Integer m_x, Integer m_y, BigDecimal m_commission) {
        super(m_name, m_x, m_y);
        this.m_commission = m_commission;
    }

    public BigDecimal getM_commission() {
        return m_commission;
    }

    public void setM_commission(BigDecimal m_commission) {
        this.m_commission = m_commission;
    }

    public Integer getM_speed() {
        return m_speed;
    }

    public void setM_speed(Integer m_speed) {
        this.m_speed = m_speed;
    }

    public void addMoney(BigDecimal money){
        m_money.add(money);
        m_money.add(m_commission);
    }

    @Override
    public String toString() {
        return "CarDeliver{" +
                super.toString() +
                "m_commission=" + m_commission +
                ", m_speed=" + m_speed +
                '}';
    }
}
