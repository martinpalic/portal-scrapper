package com.realeasy.portalscrapper;

import com.realeasy.portalscrapper.entity.Offer;

public interface OfferParser {
    Offer parseOfferPage(String htmlOfferPage);
}
