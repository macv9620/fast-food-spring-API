package com.macv.fastfood.persistence.projection;

import java.time.LocalDateTime;
import java.util.Date;

public interface OrderSummary {
    Integer getIdOrder();
    String getCustomerName();
    Date getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
