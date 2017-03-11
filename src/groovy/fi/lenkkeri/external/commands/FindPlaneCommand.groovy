package fi.lenkkeri.external.commands

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class FindPlaneCommand {
	String serialNumber
	
	static constraints = {
	}
}
