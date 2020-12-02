package guru.sfg.springframework.msscbeerservice.web.mappers;

import guru.sfg.springframework.msscbeerservice.domain.Beer;
import guru.sfg.brewery.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * @author kaan
 * @created 20 / 11 / 2020 - 20:24
 * @project mssc-beer-service
 */
@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
