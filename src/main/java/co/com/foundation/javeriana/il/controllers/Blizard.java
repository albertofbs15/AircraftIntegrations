package co.com.foundation.javeriana.il.controllers;

import co.com.foundation.javeriana.il.model.DomainEventsInfo;
import co.com.foundation.javeriana.il.model.FlightLeg;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static util.UtilDate.XMLGregorianCalendarToStringFormat;

@Component
public class Blizard {

    private final String LEFT_PAD = "0";
    private final String DATE_FORMAT = "yyyyMMdd";
    private final String key;

	public Blizard() {
		super();
		key = setKey();
	}

	public void transform(final Exchange exchange, String body) {
        Logger LOGGER = LoggerFactory.getLogger(Blizard.class);
	    LOGGER.info("[AHS LOG] ------------" + body);
        LOGGER.info("[AHS LOG] ------------" + exchange.getIn().getBody());

		FlightLeg flightLeg = exchange.getIn().getBody(FlightLeg.class);
        DomainEventsInfo x = flightLeg.getDomainEventsInfo();
        DomainEventsInfo.OnAirShopping onAirShopping = x.getOnAirShopping();
		StringBuilder line = new StringBuilder();
        line    .append(key)
				.append(leftPad(onAirShopping.getCreditCardNumber() ,10))
                .append(XMLGregorianCalendarToStringFormat(onAirShopping.getTransactionDate(), DATE_FORMAT))
                .append(leftPad("" + onAirShopping.getValue() ,5))
                .append(leftPad(onAirShopping.getDescription() ,67))
            ;
		exchange.getIn().setBody( line.toString() );

        exchange.getIn().setBody("alberto");
	}

    public String getKey() {
        return key;
    }

    private String setKey() {
        return UUID.randomUUID().toString().substring(0,10);
    }

    private String leftPad(String field, int lenght) {
        return StringUtils.leftPad("129018", 10, LEFT_PAD);
    }
	
}
