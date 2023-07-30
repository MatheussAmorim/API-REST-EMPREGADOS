package api

import java.time.LocalDate

class Empregado {

    Long id
    String nome
    Integer matricula
    LocalDate dataNascimento

    static belongsTo = [departamento: Departamento]

    static constraints = {
        nome nullable:false, blank:false, maxSize:128, unique:true
        matricula nullable:false, blank:false, unique:true
        dataNascimento nullable:false, blank:false, maxSize:128
    }
}
