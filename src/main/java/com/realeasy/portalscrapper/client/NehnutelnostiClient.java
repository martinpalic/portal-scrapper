package com.realeasy.portalscrapper.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="NehnutelnostiFeignClient", url = "https://www.nehnutelnosti.sk/byty/prenajom/?p%5Border%5D=1")
public interface NehnutelnostiClient {
    @RequestMapping(method = RequestMethod.GET, value = "")
    String getApts4Rent();
}
