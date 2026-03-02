package com.college.e_commarce.service;

import com.college.e_commarce.dto.CartProductDto;
import com.college.e_commarce.dto.OrderDto;
import com.college.e_commarce.dto.OrderListDto;
import com.college.e_commarce.dto.OrderProductDto;

public interface OrderService {

    String orderProduct(OrderProductDto orderProductDto);

    OrderListDto getAllOrders();

    OrderDto getOrder(Long id);

    void cancelOrder(Long id);
}
