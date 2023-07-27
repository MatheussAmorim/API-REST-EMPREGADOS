package api

import grails.converters.JSON
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BootStrap {

    def init = { servletContext ->

        // Configuração personalizada para formatar o LocalDate no padrão "dd/MM/yyyy"
        JSON.registerObjectMarshaller(LocalDate) { LocalDate date ->
            return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}

        Departamento departamento1 = new Departamento(nome: "Recursos Humanos")
        Departamento departamento2 = new Departamento(nome: "Suporte")
        departamento1.save()
        departamento2.save()

        Empregado empregado1 = new Empregado (nome: "Matheus", matricula: 1, dataNascimento: "1997-02-01", departamento: 1)
        Empregado empregado2 = new Empregado (nome: "Daniel", matricula: 2, dataNascimento: "1999-03-04", departamento: 1)
        Empregado empregado3 = new Empregado (nome: "César", matricula: 3, dataNascimento: "1988-03-20", departamento: 2)
        Empregado empregado4 = new Empregado (nome: "Rebeca", matricula: 4, dataNascimento: "2000-10-25", departamento: 2)
        Empregado empregado5 = new Empregado (nome: "Helena", matricula: 5, dataNascimento: "2002-05-01", departamento: 1)
        empregado1.save()
        empregado2.save()
        empregado3.save()
        empregado4.save()
        empregado5.save()

    }

    def destroy = {
    }
}
