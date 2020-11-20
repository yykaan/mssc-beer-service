package com.partnus.msscbeerservice.services;

import com.partnus.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author kaan
 * @created 21 / 11 / 2020 - 00:10
 * @project mssc-beer-service
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
