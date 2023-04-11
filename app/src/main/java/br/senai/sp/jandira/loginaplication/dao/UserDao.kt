package br.senai.sp.jandira.loginaplication.dao

import androidx.room.*
import br.senai.sp.jandira.loginaplication.model.User

@Dao
//Interface cria um contrato para que o ROOM crie métodos de gerenciamento de dados no banco
interface UserDao {

    //@Insert define que o ROOM vai usar essa classe para inserir dados
    @Insert
    fun save(user: User): Long

    //@Update define que o ROOM vai usar essa classe para atualizar dados
    @Update
    fun update(user: User): Int

    //@Delete define que o ROOM vai usar essa classe para apagar dados
    @Delete
    fun delete(user: User): Int

    //@Query define que o ROOM vai usar essa classe para dar SELECT ou selecionar dados
    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :password")
    fun authenticate(email: String, password: String): User
}