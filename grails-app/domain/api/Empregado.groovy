package api

import java.time.LocalDate

class Empregado {

    String nome
    Integer matricula
    LocalDate dataNascimento

    static belongsTo = [departamento: Departamento]

    static constraints = {
    }
}
