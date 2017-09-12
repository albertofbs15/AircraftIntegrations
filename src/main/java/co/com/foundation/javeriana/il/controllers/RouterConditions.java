package co.com.foundation.javeriana.il.controllers;

import java.util.function.Predicate;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import co.com.foundation.javeriana.il.model.FlightLegMessage;

@Component
public class RouterConditions {

	private static Predicate<FlightLegMessage> VALID_TAIL_NUMBER = (line) -> {
		return line.getAssignTailNumber().startsWith("AH-");
	};
	
	public RouterConditions() {
		super();
	}
	
	
	public boolean filter(final Exchange exchange) {
		
		FlightLegMessage flm = exchange.getIn().getBody(FlightLegMessage.class);
		return VALID_TAIL_NUMBER.test(flm);
	}
	
	public void transform(final Exchange exchange) {
		
		FlightLegMessage flm = exchange.getIn().getBody(FlightLegMessage.class);
		StringBuilder line = new StringBuilder();
		line.append( flm.getAssignTailNumber() ).append("-").append( "-thridparty" );
		exchange.getIn().setBody( line.toString() );
	}
	
	
	
}
