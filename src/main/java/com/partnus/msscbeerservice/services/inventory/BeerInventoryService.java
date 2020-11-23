package com.partnus.msscbeerservice.services.inventory;

import java.util.UUID;

/**
 * @author kaan
 * @created 22 / 11 / 2020 - 19:39
 * @project mssc-beer-service
 */
public interface BeerInventoryService {
    Integer getOnHandInventory(UUID beerId);
}
