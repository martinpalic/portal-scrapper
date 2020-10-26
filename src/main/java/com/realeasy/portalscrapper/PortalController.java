package com.realeasy.portalscrapper;

import com.realeasy.portalscrapper.entity.OfferLink;
import com.realeasy.portalscrapper.repository.OfferLinkRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PortalController {
    private final OfferLinkRepository offerLinkRepository;

    @GetMapping("/portal/scrape")
    public ResponseEntity<String> scrapePortal() throws IOException {

        Document document = Jsoup.connect("https://www.nehnutelnosti.sk/byty/prenajom/?p%5Border%5D=1").get();
        List<OfferLink> offerLinks = document.getElementsByClass("advertisement-item").stream()
                .map(element -> element.select("a"))
                .filter(link -> link.hasAttr("data-reporter-item-title"))
                .map(link -> new OfferLink(null, link.attr("href")))
                .collect(Collectors.toList());

        offerLinkRepository.saveAll(offerLinks);
        return ResponseEntity.ok("Running");
    }

    @GetMapping("/portal/links")
    public ResponseEntity<Iterable<OfferLink>> portalLinks() throws IOException {

        return ResponseEntity.ok(offerLinkRepository.findAll());
    }
}
