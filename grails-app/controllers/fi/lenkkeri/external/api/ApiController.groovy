package fi.lenkkeri.external.api

import fi.lenkkeri.external.commands.AddPersonCommand
import fi.lenkkeri.external.commands.AddPlaneCommand
import fi.lenkkeri.external.commands.FindPlaneCommand
import fi.lenkkeri.external.commands.FindPersonCommand
import fi.lenkkeri.external.equipment.PlaneData
import fi.lenkkeri.external.personnel.PilotData
import org.codehaus.groovy.runtime.InvokerHelper

/**
 * This is the API controller for XML and JSON requests/responses with a few simple methods to input/output data
 * @author Marko
 *
 */
class ApiController {
	
	def addPerson(AddPersonCommand cmd)
	{
		if (cmd.validate())
		{
			PilotData pd = new PilotData()
			InvokerHelper.setProperties(pd, cmd.properties)
			if(pd.validate())
			 {
				 pd.save()
				 def returnable = [success:true, message:"Adding person succeeded, person id " + pd.id]
				 respond returnable
			 }
			else
			{
				def returnable = [success:false, message:"Adding person failed", errors:pd.errors.allErrors]
				respond returnable
			}
		}
		else
		{
			def returnable = [success:false, message:"Adding person failed, command invalid", errors:cmd.errors.allErrors]
			respond returnable
		}
	}
	
	def addPlane(AddPlaneCommand cmd)
	{
		if (cmd.validate())
		{
			PlaneData pd = new PlaneData()
			InvokerHelper.setProperties(pd, cmd.properties)
			if(pd.validate())
			 {
				 pd.save()
				 def returnable = [success:true, message:"Adding plane succeeded, person id " + pd.id]
				 respond returnable
			 }
			else
			{
				def returnable = [success:false, message:"Adding plane failed", errors:pd.errors.allErrors]
				respond returnable
			}
		}
		else
		{
			def returnable = [success:false, message:"Adding plane failed, command invalid", errors:cmd.errors.allErrors]
			respond returnable
		}
	}
	
	def findPerson(FindPersonCommand cmd)
	{
		if(cmd.validate())
		{
			def returnable = [success:true, data:PilotData.findAllWhere(firstName:cmd.firstName, lastName:cmd.lastName)]
			respond returnable
		}
		else
		{
			def returnable = [success:false, message:"Finding person failed, command invalid", errors:cmd.errors.allErrors]
			respond returnable
		}
		
	}
	
	def findPlane(FindPlaneCommand cmd)
	{
		if(cmd.validate())
		{
			def returnable = [success:true, data:PlaneData.findAllWhere(serialNumber:cmd.serialNumber)]
			respond returnable
		}
		else
		{
			def returnable = [success:false, message:"Finding plane failed, command invalid", errors:cmd.errors.allErrors]
			respond returnable
		}
	}
}
