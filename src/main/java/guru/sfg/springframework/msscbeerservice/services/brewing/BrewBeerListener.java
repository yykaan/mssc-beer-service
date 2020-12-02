package guru.sfg.springframework.msscbeerservice.services.brewing;

import guru.sfg.brewery.model.events.BeerStyleEnum;
import guru.sfg.springframework.msscbeerservice.config.JmsConfig;
import guru.sfg.springframework.msscbeerservice.domain.Beer;
import guru.sfg.springframework.msscbeerservice.events.BrewBeerEvent;
import guru.sfg.springframework.msscbeerservice.repositories.BeerRepository;
import guru.sfg.brewery.model.events.BeerDto;
import guru.sfg.brewery.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author kaan
 * @created 29 / 11 / 2020 - 00:48
 * @project mssc-beer-inventory-service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent brewBeerEvent){
        guru.sfg.brewery.model.BeerDto beerDto = brewBeerEvent.getBeerDto();

        BeerDto dto = new BeerDto();

        dto.setBeerName(beerDto.getBeerName());
        dto.setBeerStyle(BeerStyleEnum.valueOf(beerDto.getBeerStyle().name()));
        dto.setCreatedDate(beerDto.getCreatedDate());
        dto.setId(beerDto.getId());
        dto.setLastModifiedDate(beerDto.getLastModifiedDate());
        dto.setPrice(beerDto.getPrice());
        dto.setQuantityOnHand(beerDto.getQuantityOnHand());
        dto.setUpc(beerDto.getUpc());
        dto.setVersion(beerDto.getVersion());

        Beer beer = beerRepository.getOne(beerDto.getId());

        dto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(dto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + dto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }

}
