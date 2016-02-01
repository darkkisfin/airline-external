package fi.lenkkeri.external.commands

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class AddPlaneCommand {
	String serialNumber
	String nickname
	String type
	Date manufactured
	Date acquired
	Date lastMaintenance
	
	Double length
	Double width
	Double weight
	Long crewRequired
	Long seatCount
	Double fuelCapacity
	Double nominalRange
	Double maximumRange
	
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
    }
}