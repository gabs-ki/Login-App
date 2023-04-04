package br.senai.sp.jandira.loginaplication.repository

import android.content.Context
import br.senai.sp.jandira.loginaplication.dao.TripDb
import br.senai.sp.jandira.loginaplication.model.User

class UserRepository(context: Context) {
    private val db = TripDb.getDatabase(context = context)

    fun save(user: User): Long {
        return db.userDao().save(user)
    }
}