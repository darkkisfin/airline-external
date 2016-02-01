package fi.lenkkeri.external.jobs

import fi.lenkkeri.external.equipment.PlaneData
import fi.lenkkeri.external.personnel.PilotData


/**
 * This class inserts a large amount of pilots and planes to the system.
 * @author darkkis
 *
 */
class InitialTestDataJob {
	
	def sessionFactory
	def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP
	def sessionRequired = true
	def concurrent = false
	
    static triggers = {
    }

    def execute() {
        // execute job
		log.debug "Starting to insert new testing data into DB."
		println "Inserting pilot data"
		for(int i=1; i<10001; i++)
		{
			PilotData testPilot = PilotData.build()
			if(i%100==0)
			{
				flushJob()
			}
			testPilot.save()
		}
		println "Inserting plane data"
		for(int i=1; i<1001; i++)
		{
			PlaneData testPlane = PlaneData.build()
			if(i%100==0)
			{
				flushJob()
			}
			testPlane.save()
		}
		println "Insert complete"
		log.debug "Testing data inserted."
    }
	
	public void flushJob()
	{
		def session = sessionFactory.currentSession
		try
		{
			session.flush()
		} finally
		{
			try {
				session.clear()
			} catch (Exception e) {
				log.error("error clearing session ", e);
			}
			try {
				propertyInstanceMap.get().clear()
			} catch (Exception e) {
				log.error("error clearing property instances", e);
			}
		}
	}
}
