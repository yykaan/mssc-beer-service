package guru.sfg.brewery.model.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kaan
 * @created 29 / 11 / 2020 - 00:32
 * @project mssc-beer-inventory-service
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 3244248786566345959L;

    private BeerDto beerDto;
}
