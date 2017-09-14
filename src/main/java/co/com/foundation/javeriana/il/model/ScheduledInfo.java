//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.14 at 06:17:24 PM COT 
//


package co.com.foundation.javeriana.il.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for scheduled-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="scheduled-info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estimated-outgate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estimated-ingate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estimated-outgate-time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="estimated-ingate-time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduled-info", propOrder = {
    "estimatedOutgate",
    "estimatedIngate",
    "estimatedOutgateTime",
    "estimatedIngateTime"
})
public class ScheduledInfo {

    @XmlElement(name = "estimated-outgate", required = true)
    protected String estimatedOutgate;
    @XmlElement(name = "estimated-ingate", required = true)
    protected String estimatedIngate;
    @XmlElement(name = "estimated-outgate-time", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedOutgateTime;
    @XmlElement(name = "estimated-ingate-time", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedIngateTime;

    /**
     * Gets the value of the estimatedOutgate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimatedOutgate() {
        return estimatedOutgate;
    }

    /**
     * Sets the value of the estimatedOutgate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimatedOutgate(String value) {
        this.estimatedOutgate = value;
    }

    /**
     * Gets the value of the estimatedIngate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimatedIngate() {
        return estimatedIngate;
    }

    /**
     * Sets the value of the estimatedIngate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimatedIngate(String value) {
        this.estimatedIngate = value;
    }

    /**
     * Gets the value of the estimatedOutgateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedOutgateTime() {
        return estimatedOutgateTime;
    }

    /**
     * Sets the value of the estimatedOutgateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedOutgateTime(XMLGregorianCalendar value) {
        this.estimatedOutgateTime = value;
    }

    /**
     * Gets the value of the estimatedIngateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedIngateTime() {
        return estimatedIngateTime;
    }

    /**
     * Sets the value of the estimatedIngateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedIngateTime(XMLGregorianCalendar value) {
        this.estimatedIngateTime = value;
    }

}
