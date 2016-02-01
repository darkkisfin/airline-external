package fi.lenkkeri.external.personnel

import grails.transaction.Transactional
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.xml.ws.ResponseWrapper
import org.grails.cxf.utils.GrailsCxfEndpoint
import org.grails.cxf.utils.EndpointType


@Transactional
@GrailsCxfEndpoint(address='/pilotdata' ,expose = EndpointType.JAX_WS_WSDL)
class PilotDataService {
	
	@WebMethod(operationName="listAllPilots")
	@WebResult(name="pilotData")
	List<PilotData> listAllPilots(@WebParam(name="max")Integer max, @WebParam(name="offset")Integer offset)
	{
		def maxItems = max?:100
		def offsetItems = offset?:0
		return PilotData.list(max:maxItems, offset:offsetItems)
	}
	
	@WebMethod(operationName="findPilotsByName")
	@WebResult(name="pilotData")
	List<PilotData> findPilotsByName(@WebParam(name="max")Integer max, @WebParam(name="offset")Integer offset, @WebParam(name="firstName")String firstName, @WebParam(name="lastName")String lastName)
	{
		def maxItems = max?:100
		def offsetItems = offset?:0
		return PilotData.findAllByFirstNameAndLastName(firstName, lastName, [max:maxItems, offset:offsetItems])
	}
	
}
