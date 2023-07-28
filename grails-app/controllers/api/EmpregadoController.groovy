package api
import grails.validation.ValidationException

import java.time.LocalDate

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional


@ReadOnly
class EmpregadoController {

    EmpregadoService empregadoService

    static responseFormats = ['json']

    String formatLocalDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /*def index(Integer max) {
       params.max = Math.min(max ?: 10, 100)
       respond empregadoService.list(params), model:[empregadoCount: empregadoService.count()]
    }*/

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def empregados = empregadoService.list(params)

        def listaEmpregados = empregados.collect { empregado ->
            [       id:empregado.id,
                    departamento:empregado.departamento.id,
                    matricula:empregado.matricula,
                    nome:empregado.nome,
                    dataNascimento:empregado.dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))]
        }
        respond listaEmpregados, model: [empregadoCount: empregadoService.count()]
    }

    def show(Long id) {
        respond empregadoService.get(id)
    }

    @Transactional
    def save(Empregado empregado) {
        if (empregado == null) {
            render status: NOT_FOUND
            return
        }
        if (empregado.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empregado.errors
            return
        }

        try {
            empregadoService.save(empregado)
        } catch (ValidationException e) {
            respond empregado.errors
            return
        }

        respond empregado, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Empregado empregado) {
        if (empregado == null) {
            render status: NOT_FOUND
            return
        }
        if (empregado.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empregado.errors
            return
        }

        try {
            empregadoService.save(empregado)
        } catch (ValidationException e) {
            respond empregado.errors
            return
        }

        respond empregado, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || empregadoService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
