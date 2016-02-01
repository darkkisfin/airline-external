package fi.lenkkeri.external.personnel



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PilotDataController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PilotData.list(params), model:[pilotDataInstanceCount: PilotData.count()]
    }

    def show(PilotData pilotDataInstance) {
        respond pilotDataInstance
    }

    def create() {
        respond new PilotData(params)
    }

    @Transactional
    def save(PilotData pilotDataInstance) {
        if (pilotDataInstance == null) {
            notFound()
            return
        }

        if (pilotDataInstance.hasErrors()) {
            respond pilotDataInstance.errors, view:'create'
            return
        }

        pilotDataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pilotData.label', default: 'PilotData'), pilotDataInstance.id])
                redirect pilotDataInstance
            }
            '*' { respond pilotDataInstance, [status: CREATED] }
        }
    }

    def edit(PilotData pilotDataInstance) {
        respond pilotDataInstance
    }

    @Transactional
    def update(PilotData pilotDataInstance) {
        if (pilotDataInstance == null) {
            notFound()
            return
        }

        if (pilotDataInstance.hasErrors()) {
            respond pilotDataInstance.errors, view:'edit'
            return
        }

        pilotDataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PilotData.label', default: 'PilotData'), pilotDataInstance.id])
                redirect pilotDataInstance
            }
            '*'{ respond pilotDataInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PilotData pilotDataInstance) {

        if (pilotDataInstance == null) {
            notFound()
            return
        }

        pilotDataInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PilotData.label', default: 'PilotData'), pilotDataInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pilotData.label', default: 'PilotData'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
