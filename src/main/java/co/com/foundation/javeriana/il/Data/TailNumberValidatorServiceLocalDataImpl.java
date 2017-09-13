package co.com.foundation.javeriana.il.Data;

import java.util.HashSet;
import java.util.Set;

public class TailNumberValidatorServiceLocalDataImpl implements TailNumberValidatorService {

    private final Set<String> validTailNumbers;
    public TailNumberValidatorServiceLocalDataImpl () {
        validTailNumbers = new HashSet<String>();
        validTailNumbers.add("tailNumber1");
        validTailNumbers.add("tailNumber2");
    }

    @Override
    public boolean validateTailNumber(String tailNumber) {
        return tailNumber != null && validTailNumbers.contains(tailNumber);
    }
}
