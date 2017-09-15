package co.com.foundation.javeriana.il.controllers;

import co.com.foundation.javeriana.il.model.AircratlineMessage;
import co.com.foundation.javeriana.il.model.DomainEventsInfo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static util.UtilDate.XMLGregorianCalendarToStringFormat;

@Component
public class Blizard implements Processor {

    Logger LOGGER = LoggerFactory.getLogger(Blizard.class);

    private final String LEFT_NUMBER_PAD = "0";
    private final String RIGHT_STRING_PAD = " ";
    private final String DATE_FORMAT = "yyyyMMdd";

    public Blizard() {
        super();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        AircratlineMessage aircratlineMessage = exchange.getIn().getBody(AircratlineMessage.class);
        DomainEventsInfo.OnAirShopping onAirShopping = aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping();
        StringBuilder line = new StringBuilder();
        final String key = getKey();
        line.append(key)
                .append(leftPad(onAirShopping.getCreditCardNumber(), 16))
                .append(XMLGregorianCalendarToStringFormat(onAirShopping.getTransactionDate(), DATE_FORMAT))
                .append(leftPad("" + onAirShopping.getValue(), 5))
                .append(rigthPad(onAirShopping.getDescription(), 67))
        ;

        LOGGER.info("Processing Blizard Regiter... Id: " + key);
        exchange.getIn().setBody(line.toString());
        exchange.getIn().setHeader("key", key);
    }

    public String getKey() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private String leftPad(String field, int lenght) {
        return StringUtils.leftPad(field, lenght, LEFT_NUMBER_PAD);
    }

    private String rigthPad(String field, int lenght) {
        return StringUtils.rightPad(field, lenght, RIGHT_STRING_PAD);
    }

}
