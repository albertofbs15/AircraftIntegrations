//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.12 at 11:41:55 AM COT 
//


package co.com.foundation.javeriana.il.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flight-status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="flight-status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SCHEDULED"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "flight-status")
@XmlEnum
public enum FlightStatus {

    SCHEDULED,
    IN_PROGRESS,
    COMPLETED;

    public String value() {
        return name();
    }

    public static FlightStatus fromValue(String v) {
        return valueOf(v);
    }

}