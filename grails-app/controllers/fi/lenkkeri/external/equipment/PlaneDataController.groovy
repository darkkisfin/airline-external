package fi.lenkkeri.external.equipment



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlaneDataController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PlaneData.list(params), model:[planeDataInstanceCount: PlaneData.count()]
    }

    def show(PlaneData planeDataInstance) {
        respond planeDataInstance
    }

    def create() {
        respond new PlaneData(params)
    }

    @Transactional
    def save(PlaneData planeDataInstance) {
        if (planeDataInstance == null) {
            notFound()
            return
        }

        if (planeDataInstance.hasErrors()) {
            respond planeDataInstance.errors, view:'create'
            return
        }

        planeDataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'planeData.label', default: 'PlaneData'), planeDataInstance.id])
                redirect planeDataInstance
            }
            '*' { respond planeDataInstance, [status: CREATED] }
        }
    }

    def edit(PlaneData planeDataInstance) {
        respond planeDataInstance
    }

    @Transactional
    def update(PlaneData planeDataInstance) {
        if (planeDataInstance == null) {
            notFound()
            return
        }

        if (planeDataInstance.hasErrors()) {
            respond planeDataInstance.errors, view:'edit'
            return
        }

        planeDataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PlaneData.label', default: 'PlaneData'), planeDataInstance.id])
                redirect planeDataInstance
            }
            '*'{ respond planeDataInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PlaneData planeDataInstance) {

        if (planeDataInstance == null) {
            notFound()
            return
        }

        planeDataInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PlaneData.label', default: 'PlaneData'), planeDataInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'planeData.label', default: 'PlaneData'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
