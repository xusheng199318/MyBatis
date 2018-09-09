package com.arthur.cascade;

import com.arthur.pojo.Order;
import com.arthur.pojo.UserDTO;

import java.util.List;

public interface OrderMapper {

    List<Order> getOrderList();

    List<UserDTO> getUserOrderList();
}
