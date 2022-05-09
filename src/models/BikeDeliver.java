package models;

import java.math.BigDecimal;

public class BikeDeliver extends Delivers{
    private BigDecimal m_commission;

    private Integer m_speed = 10;

    public BikeDeliver(String m_name, Integer m_x, Integer m_y, BigDecimal m_commission) {
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

    @Override
    public String toString() {
        return "BikeDeliver{" +
                super.toString() +
                "m_commission=" + m_commission +
                ", m_speed=" + m_speed +
                '}';
    }
}
