package guru.sfg.springframework.msscbeerservice.events;

import guru.sfg.brewery.model.BeerDto;
import lombok.*;

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
