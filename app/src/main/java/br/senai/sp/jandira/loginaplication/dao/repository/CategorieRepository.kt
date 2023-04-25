package br.senai.sp.jandira.loginaplication.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginaplication.R
import br.senai.sp.jandira.loginaplication.model.Category

class CategorieRepository {

    companion object {

        @Composable
        fun getCategoriesList () : List<Category>{


            return listOf<Category>(
                Category(
                    id = 1,
                    name = "Montain",
                    image = painterResource(id = R.drawable.montain_icon)
                ),
                Category(
                    id = 2,
                    name = "Snow",
                    image = painterResource(id = R.drawable.snow_icon)
                ),
                Category(
                    id = 3,
                    name = "Beach",
                    image = painterResource(id = R.drawable.beach_icon_4)
                )
            )
        }




    }


}