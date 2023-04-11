package br.senai.sp.jandira.loginaplication.repository

import android.content.Context
import br.senai.sp.jandira.loginaplication.dao.TripDb
import br.senai.sp.jandira.loginaplication.model.User

//Criado o repositório
//Quando a aplicação precisa dos dados, ela acessa o repositório
class UserRepository(context: Context) {
    //Variavel que recebe a instância do banco
    private val db = TripDb.getDatabase(context = context)

    //Retorna o Long que é o ID
    //Chama a função para salvar um User
    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }
}