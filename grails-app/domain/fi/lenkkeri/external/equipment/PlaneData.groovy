package fi.lenkkeri.external.equipment

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.NONE)
class PlaneData implements Serializable{
	@XmlElement
	String serialNumber
	@XmlElement
	String nickname
	@XmlElement
	String type
	@XmlElement
	Date manufactured
	@XmlElement
	Date acquired
	@XmlElement
	Date lastMaintenance
	
	@XmlElement
	Double length
	@XmlElement
	Double width
	@XmlElement
	Double weight
	@XmlElement
	Long crewRequired
	@XmlElement
	Long seatCount
	@XmlElement
	Double fuelCapacity
	@XmlElement
	Double nominalRange
	@XmlElement
	Double maximumRange
	
	static hasMany = [maintenanceLog:String]
	
    static constraints = {
		serialNumber minSize: 25, maxSize: 25, matches: "[a-z0-9]{25}"
		nickname size:3..50, matches: "([a-zA-Z]){3,25}"
		type maxSize:10, matches: "([a-zA-Z]){0,10}"
		manufactured attributes:[years:1950..2015]
		acquired attributes:[years:1950..2015]
		lastMaintenance attributes:[years:1950..2015]
		length min:1500d, max: 100000.0d
		width min:1500.0d, max: 100000.0d
		weight min:1000.0d, max: 100000.0d
		crewRequired min:1l, max:100l
		seatCount min:1l, max: 500l
		fuelCapacity min:5000.0d, max:50000.0d
		nominalRange min:100.0d, max:10000.0d
		maximumRange min:100.0d, max:50000.0d
		maintenanceLog nullable:true
    }
}
