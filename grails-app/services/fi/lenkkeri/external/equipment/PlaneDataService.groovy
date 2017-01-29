package fi.lenkkeri.external.equipment

import grails.transaction.Transactional
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.xml.ws.ResponseWrapper
import org.grails.cxf.utils.GrailsCxfEndpoint
import org.grails.cxf.utils.EndpointType

@Transactional
@GrailsCxfEndpoint(address='/planedata' ,expose = EndpointType.JAX_WS_WSDL)
class PlaneDataService {
	
	@WebMethod(operationName="listAllPlanes")
	@WebResult(name="planeData")
	List<PlaneData> listAllPlanes(@WebParam(name="max")Integer max, @WebParam(name="offset")Integer offset)
	{
		def maxItems = max?:100
		def offsetItems = offset?:0
		return PlaneData.list(max:maxItems, offset:offsetItems)
	}
	
	@WebMethod(operationName="findPlanesByType")
	@WebResult(name="planeData")
	List<PlaneData> findPlanesByType(@WebParam(name="type")String type, @WebParam(name="max")Integer max, @WebParam(name="offset")Integer offset)
	{
		def maxItems = max?:100
		def offsetItems = offset?:0
		return PlaneData.findAllByType(type, [max:maxItems, offset:offsetItems])
	}
	
	@WebMethod(operationName="findPlaneBySN")
	@WebResult(name="planeData")
	List<PlaneData> findPlaneBySN(@WebParam(name="serialNumber")String serialNumber)
	{
		return PlaneData.findBySerialNumber(serialNumber)
	}
/*
	@WebMethod(operationName="findPlaneByNickname")
	@WebResult(name="planeData")
	List<PlaneData> findPlaneByNickname(@WebParam(name="nickname")String nickname)
	{
		return PlaneData.findByNickname(nickname)
	}
*/
}

