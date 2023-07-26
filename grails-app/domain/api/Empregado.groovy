package api

import java.time.LocalDate

class Empregado {

    String nome
    String sobrenome

    LocalDate dataNascimento

    static belongsTo = [departamento: Departamento]

    static constraints = {
    }
}
