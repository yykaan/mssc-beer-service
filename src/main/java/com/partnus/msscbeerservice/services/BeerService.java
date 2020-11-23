package com.partnus.msscbeerservice.services;

import com.partnus.msscbeerservice.web.model.BeerDto;
import com.partnus.msscbeerservice.web.model.BeerPagedList;
import com.partnus.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * @author kaan
 * @created 21 / 11 / 2020 - 00:10
 * @project mssc-beer-service
 */
public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, Boolean showInventoryOnHand, PageRequest of);
}
