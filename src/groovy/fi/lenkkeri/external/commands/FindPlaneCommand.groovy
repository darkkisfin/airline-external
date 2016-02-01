package fi.lenkkeri.external.commands

import org.grails.databinding.BindingFormat

@grails.validation.Validateable
class FindPlaneCommand {
	String serialNumber
	
	static constraints = {
		serialNumber minSize: 25, maxSize: 25, matches: "[a-z0-9]{25}"
	}
}