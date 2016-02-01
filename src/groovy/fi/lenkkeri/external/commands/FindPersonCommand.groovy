package fi.lenkkeri.external.commands

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class FindPersonCommand {
	String firstName
	String lastName
	
	static constraints = {
		firstName blank:false, size: 2..50, matches: "([A-Z])([a-z\\s]){2,49}"
		lastName blank:false, size: 1..50, matches: "([A-Z])([a-z\\s]){0,49}"
	}
}