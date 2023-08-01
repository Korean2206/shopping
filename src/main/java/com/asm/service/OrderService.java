package com.asm.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.asm.entity.Order;

public interface OrderService {

    Order create(JsonNode orderData);

}
