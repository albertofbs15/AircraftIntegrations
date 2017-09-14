package co.com.foundation.javeriana.il.Data;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class TailNumberValidatorServiceLocalDataImpl implements TailNumberValidatorService {

    private static final String PREFIX = "MK";

    @Override
    public boolean validateTailNumber(String tailNumber) {
        return tailNumber.length() == 7 && tailNumber.startsWith(PREFIX) && isSufixNumeric(tailNumber);
    }

    public boolean isSufixNumeric (String tailNumber) {
        try {
            Integer.parseInt(tailNumber.substring(2));
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
