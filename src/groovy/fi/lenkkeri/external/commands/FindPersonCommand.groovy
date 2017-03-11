package fi.lenkkeri.external.commands

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class FindPersonCommand {
	String firstName
	String lastName
	
	static constraints = {
		firstName nullable:true
		lastName nullable:true
	}
}
