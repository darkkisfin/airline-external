package fi.lenkkeri.external.personnel

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.NONE)
class PilotData implements Serializable {
	@XmlElement
	String firstName
	@XmlElement
	String lastName
	@XmlElement
	String middleName
	@XmlElement
	Date birthDate
	@XmlElement
	Date enteredEmployment
	@XmlElement
	String callsign
	
    static constraints = {
		firstName blank:false, size: 2..50, matches: "([A-Z])([a-z\\s]){2,49}"
		lastName blank:false, size: 1..50, matches: "([A-Z])([a-z\\s]){0,49}"
		middleName blank:true, size:0..50, matches: "([A-Z])([a-z\\s]){0,49}"
		birthDate attributes: [years: 1900..1997]
		enteredEmployment attributes: [years: 1918..2016]
		callsign blank:true, size:0..50, nullable:true, matches: "([A-Z])([a-z\\s]){0,49}"
    }
}
