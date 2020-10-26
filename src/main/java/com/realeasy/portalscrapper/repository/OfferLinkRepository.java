package com.realeasy.portalscrapper.repository;

import com.realeasy.portalscrapper.entity.OfferLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferLinkRepository extends CrudRepository<OfferLink, Long> {
}
