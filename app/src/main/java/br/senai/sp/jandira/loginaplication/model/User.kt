package br.senai.sp.jandira.loginaplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity define o nome da tabela quando for criada no banco
@Entity(tableName = "tbl_user")

//Data diz que a classe é responsável para criar uma tabela no banco de dados
data class User(

    //Define como chave primária
    @PrimaryKey(autoGenerate = true) var id: Long = 0,

    // ColumnInfo define como o nome da váriavel vai ser criada no banco de dados
    @ColumnInfo(name = "user_name") var userName: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    @ColumnInfo(name = "is_over") var isOver18: Boolean = false
) {

}
