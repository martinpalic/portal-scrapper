package com.realeasy.portalscrapper;

import com.realeasy.portalscrapper.entity.Offer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NehnutelnostiOfferParserImpl implements OfferParser {
    @Override
    public Offer parseOfferPage(String htmlOfferPage) {
        Offer offer = new Offer();
        Document document = Jsoup.parse(htmlOfferPage);

        Element infoDiv = document.getElementsByClass("sub--head").first();
        offer.setHeadline(infoDiv.child(0).select("h1").first().ownText());

        Element span = infoDiv.child(1).select("span").first();
        offer.setAddress(span.ownText() + span.select("a").first().ownText());

        offer.setPrice(extractNumber(infoDiv.child(2).getElementsByClass("price--main").select("span").first().ownText()));

        Element infoTable = infoDiv.getElementsByClass("parameter--info").first().child(0);
        offer.setRoomCount(extractNumber(infoTable.child(0).child(1).select("strong").first().ownText()));
        offer.setSize(extractNumber(infoTable.child(1).child(0).child(0).ownText()));
        offer.setVendorId(infoTable.child(2).child(1).child(0).ownText());

        offer.setText(infoDiv.getElementsByClass("text-inner").first().wholeText());

        String img = infoDiv.parent().child(0).child(0).child(0).attr("srcset");
        offer.setCoverImageLink(
                img
        );

        return offer;
    }

    private int extractNumber(String string){
        return Integer.parseInt(string.replaceAll("[^0-9]", ""));
    }
}
