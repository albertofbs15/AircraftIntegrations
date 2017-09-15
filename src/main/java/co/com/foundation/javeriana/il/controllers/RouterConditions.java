package co.com.foundation.javeriana.il.controllers;

import java.util.function.Predicate;

import co.com.foundation.javeriana.il.Data.TailNumberValidatorService;
import co.com.foundation.javeriana.il.Data.TailNumberValidatorServiceLocalDataImpl;
import co.com.foundation.javeriana.il.model.AircratlineMessage;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouterConditions {

	@Autowired
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
	
}
