package guru.sfg.brewery.model.events;

import lombok.NoArgsConstructor;

/**
 * @author kaan
 * @created 29 / 11 / 2020 - 00:34
 * @project mssc-beer-inventory-service
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
