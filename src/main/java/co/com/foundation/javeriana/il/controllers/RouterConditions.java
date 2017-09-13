package co.com.foundation.javeriana.il.controllers;

import java.util.function.Predicate;

import co.com.foundation.javeriana.il.Data.TailNumberValidatorService;
import co.com.foundation.javeriana.il.model.AircratlineMessage;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.foundation.javeriana.il.model.FlightLegMessage;

@Component
public class RouterConditions {

	TailNumberValidatorService tailNumberValidatorService;

	private final Predicate<AircratlineMessage> VALID_TAIL_NUMBER = (line) -> {
		return tailNumberValidatorService.validateTailNumber(line.getTailNumber());
	};
	
	public RouterConditions() {
		super();
	}
	
	
	public boolean filter(final Exchange exchange) {
		AircratlineMessage flm = exchange.getIn().getBody(AircratlineMessage.class);
		return VALID_TAIL_NUMBER.test(flm);
	}

	public boolean route(final Exchange exchange) {
		AircratlineMessage flm = exchange.getIn().getBody(AircratlineMessage.class);
		flm.getFlightLeg().get(0).getDomainEventsInfo().getOnAirShopping()
		return VALID_TAIL_NUMBER.test(flm);
	}
	
	public void transform(final Exchange exchange) {
		
		FlightLegMessage flm = exchange.getIn().getBody(FlightLegMessage.class);
		StringBuilder line = new StringBuilder();
		line.append( flm.getAssignTailNumber() ).append("-").append( "-thridparty" );
		exchange.getIn().setBody( line.toString() );
	}
	
	
	
}
