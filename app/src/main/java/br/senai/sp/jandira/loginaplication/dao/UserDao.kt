package br.senai.sp.jandira.loginaplication.dao

import androidx.room.*
import br.senai.sp.jandira.loginaplication.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Update
    fun uptade(user: User): Int

    @Delete
    fun delete(user: User): Int

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User
}