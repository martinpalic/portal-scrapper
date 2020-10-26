package com.realeasy.portalscrapper;

import com.realeasy.portalscrapper.client.NehnutelnostiClient;
import org.springframework.stereotype.Component;

@Component
public class SearchParser {

    private NehnutelnostiClient client;

    public SearchParser(NehnutelnostiClient client) {
        String apts4Rent = client.getApts4Rent();

    }
}
