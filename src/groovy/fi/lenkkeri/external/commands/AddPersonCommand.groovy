package fi.lenkkeri.external.commands

import java.util.Date;

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class AddPersonCommand {
	String firstName
	String lastName
	String middleName
	Date birthDate
	Date enteredEmployment
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