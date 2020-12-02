package guru.sfg.springframework.msscbeerservice.services.brewing;

import guru.sfg.springframework.msscbeerservice.config.JmsConfig;
import guru.sfg.springframework.msscbeerservice.domain.Beer;
import guru.sfg.springframework.msscbeerservice.events.BrewBeerEvent;
import guru.sfg.springframework.msscbeerservice.repositories.BeerRepository;
import guru.sfg.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import guru.sfg.springframework.msscbeerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kaan
 * @created 29 / 11 / 2020 - 00:35
 * @project mssc-beer-inventory-service
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQHO = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory Onhand is: " + invQHO);

            if (beer.getMinOnHand() >= invQHO){
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });

    }
}
