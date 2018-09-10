package com.arthur.lazyloading;

import com.arthur.pojo.Order;
import com.arthur.pojo.User;
import com.arthur.pojo.UserDTO;

import java.util.List;

public interface OrderMapper {

    List<Order> getOrderList();

    List<UserDTO> getUserOrderList();

    Order getOrderById(Integer orderId);

    User getUserById(Integer userId);

    Order findOrdersAndUser(Integer orderId);
}
