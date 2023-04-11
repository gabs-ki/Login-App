package br.senai.sp.jandira.loginaplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.loginaplication.model.User

//Database representa o nosso banco de dados
//entities representa as tabelas ou entidades do banco
@Database(entities = [User::class], version = 1)
abstract class TripDb: RoomDatabase() {

    //O TripDB que cria o trafego de dados entre o banco a e minha aplicação
    //Importa todas as entidades para o TripDB fazer o gerenciamento
   abstract fun userDao(): UserDao

   //companion faz com que os dados sejam estáticos
   companion object{

       //private torna a váriavel privada
       private lateinit var instanceDb: TripDb

       //fun serve para criar uma função
       //getDatabase tras uma instancia do banco e caso ele n exista, cai no If para
       // criar o banco de dados
       fun getDatabase(context: Context): TripDb {

           if (!::instanceDb.isInitialized){
               instanceDb = Room
                   .databaseBuilder(
                       context,
                       TripDb::class.java,
                       "db_trip"
                   ).allowMainThreadQueries().build()

           }
           return instanceDb
       }
   }
}