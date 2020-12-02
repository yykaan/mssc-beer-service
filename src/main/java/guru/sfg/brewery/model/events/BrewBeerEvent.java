package guru.sfg.brewery.model.events;

import lombok.NoArgsConstructor;

/**
 * @author kaan
 * @created 29 / 11 / 2020 - 00:33
 * @project mssc-beer-inventory-service
 */
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
