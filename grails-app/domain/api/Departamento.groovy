package api

class Departamento {

    Long id
    String nome
    static hasMany = [empregados: Empregado]

    static constraints = {
        nome nullable:false, blank:false, maxSize:128
    }
}
