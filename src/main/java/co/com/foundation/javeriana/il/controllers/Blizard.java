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

    private final String LEFT_PAD = "0";
    private final String DATE_FORMAT = "yyyyMMdd";
    private final String key;

    public Blizard() {
        super();
        key = setKey();
    }

    public boolean hasEvent(Exchange exchange){
        AircratlineMessage aircratlineMessage = exchange.getIn().getBody(AircratlineMessage.class);
        return aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo() != null && aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping() != null;
    }

    public boolean hasEvent(AircratlineMessage aircratlineMessage){
        return aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo() != null && aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping() != null;
    }

    public String transform(Exchange exchange) throws Exception {
        AircratlineMessage aircratlineMessage = exchange.getIn().getBody(AircratlineMessage.class);

        DomainEventsInfo.OnAirShopping onAirShopping = aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping();

        StringBuilder line = new StringBuilder();
        line.append(key)
                .append(leftPad(onAirShopping.getCreditCardNumber(), 10))
                .append(XMLGregorianCalendarToStringFormat(onAirShopping.getTransactionDate(), DATE_FORMAT))
                .append(leftPad("" + onAirShopping.getValue(), 5))
                .append(leftPad(onAirShopping.getDescription(), 67))
        ;
        return line.toString();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        AircratlineMessage aircratlineMessage = exchange.getIn().getBody(AircratlineMessage.class);

        if (hasEvent(aircratlineMessage)) {
            DomainEventsInfo.OnAirShopping onAirShopping = aircratlineMessage.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping();

            StringBuilder line = new StringBuilder();
            line.append(key)
                    .append(leftPad(onAirShopping.getCreditCardNumber(), 10))
                    .append(XMLGregorianCalendarToStringFormat(onAirShopping.getTransactionDate(), DATE_FORMAT))
                    .append(leftPad("" + onAirShopping.getValue(), 5))
                    .append(leftPad(onAirShopping.getDescription(), 67))
            ;
            exchange.getIn().setBody(line.toString());
        }
    }

    public String getKey() {
        return key;
    }

    private String setKey() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private String leftPad(String field, int lenght) {
        return StringUtils.leftPad("129018", 10, LEFT_PAD);
    }

}
