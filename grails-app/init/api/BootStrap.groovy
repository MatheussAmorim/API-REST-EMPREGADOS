package api

class BootStrap {

    def init = { servletContext ->

        Departamento departamento1 = new Departamento(nome: "Recursos Humanos")
        Departamento departamento2 = new Departamento(nome: "Suporte")
        departamento1.save()
        departamento2.save()

        Empregado empregado1 = new Empregado (nome: "Matheus", sobrenome: "Amorim", dataNascimento: "1997-02-01", departamento: 1)
        Empregado empregado2 = new Empregado (nome: "Daniel", sobrenome: "Rodrigues", dataNascimento: "1999-03-04", departamento: 1)
        Empregado empregado3 = new Empregado (nome: "César", sobrenome: "Teixeira", dataNascimento: "1988-03-20", departamento: 2)
        Empregado empregado4 = new Empregado (nome: "Rebeca", sobrenome: "Alicia", dataNascimento: "2000-10-25", departamento: 2)
        Empregado empregado5 = new Empregado (nome: "Helena", sobrenome: "Novaes", dataNascimento: "2002-05-01", departamento: 1)
        empregado1.save()
        empregado2.save()
        empregado3.save()
        empregado4.save()
        empregado5.save()
    }
    def destroy = {
    }
}
