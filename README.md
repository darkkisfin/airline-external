# airline-external
If Grails is not installed, run ./grailsw

Configure database etc in /grails-app/conf/

When completed installation and configuration, use grails commandline tool, and run with run-app

When running, call the url http://localhost:8080/airline-external/admin/triggerDatabase to populate database. Wait until call has completed (follow grails commandline debug log)

WSDL's fetchable from:
http://localhost:8080/airline-external/services/planedata?wsdl
http://localhost:8080/airline-external/services/pilotdata?wsdl

JSON/XML api at:
http://localhost:8080/airline-external/api/xml/<methodname>
http://localhost:8080/airline-external/api/json/<methodname>

See methods in /grails-app/controllers/.../external/api/ApiController.java
Data format in /src/groovy/.../commands/

Use curl or similar tool to call with body data or just web browser with get params like in command object. For ApiController methods.

Old testing script in /doc/ can be used as basis for SOAP calls. For CXF Service methods.
