package fi.lenkkeri.external.util
import fi.lenkkeri.external.jobs.InitialTestDataJob
import grails.converters.JSON


/**
 * This controller is used to trigger database content generation
 * @author Marko
 *
 */
class AdminController {
	def triggerDatabase()
	{
		InitialTestDataJob.triggerNow()
		def renderable = [:]
		renderable.message="Started generating DB contents."
		render renderable as JSON
	}
}
