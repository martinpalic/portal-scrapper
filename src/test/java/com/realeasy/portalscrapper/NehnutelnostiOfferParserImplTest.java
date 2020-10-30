package com.realeasy.portalscrapper;

import com.realeasy.portalscrapper.entity.Offer;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NehnutelnostiOfferParserImplTest {

    @Test
    public void parserTest() throws IOException {
        String connect = Jsoup.connect("https://www.nehnutelnosti.sk/4164747/dom-realit-a-byvanie-v-novom-a-svetlom-3i-byte-na-zaciatku-dubravky/").get().toString();
        Offer offer = new NehnutelnostiOfferParserImpl().parseOfferPage(connect);
    }

}