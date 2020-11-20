package com.partnus.msscbeerservice.repositories;

import com.partnus.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author kaan
 * @created 20 / 11 / 2020 - 10:51
 * @project mssc-beer-service
 */
@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
