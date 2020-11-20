package com.partnus.msscbeerservice.web.mappers;

import com.partnus.msscbeerservice.domain.Beer;
import com.partnus.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author kaan
 * @created 20 / 11 / 2020 - 20:24
 * @project mssc-beer-service
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
