package br.senai.sp.jandira.loginaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginaplication.dao.repository.CategorieRepository
import br.senai.sp.jandira.loginaplication.model.Categories
import br.senai.sp.jandira.loginaplication.ui.theme.LoginAplicationTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAplicationTheme {
                // A surface container using the 'background' color from the theme
                HomeSc()

            }
        }
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeSc(){
    HomeScreen(categories = CategorieRepository.getCategoriesList())
}

@Composable
fun HomeScreen(categories: List<Categories>) {
  Surface(
      modifier = Modifier
          .fillMaxSize()
  ) {
      Box(
          modifier = Modifier
              .fillMaxWidth()
              .height(300.dp),
      ) {
          Image(
              painter = painterResource(id = R.drawable.paris),
              contentDescription = ""
          )
      }

      Column(
          modifier = Modifier
              .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween
      ) {
      }

      Column (
          horizontalAlignment = Alignment.End,
          modifier = Modifier
              .padding(13.dp)
              ) {
          
          Column( modifier = Modifier
              .height(62.dp)
              .width(62.dp)
              .background(
                  colorResource(id = R.color.white),
                  shape = RoundedCornerShape(50)
              ),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally) {
              Image(
                  painter = painterResource(id = R.drawable.susanna_profile),
                  contentDescription = "",
                  modifier = Modifier
                      .clip(shape = RoundedCornerShape(50.dp))
                      .height(57.dp)
                      .width(57.dp))
          }

          Text(text = "Susanna Halft")

          Column(
              modifier = Modifier
                  .fillMaxWidth()
                  .height(100.dp),
              verticalArrangement = Arrangement.Bottom
          ) {
              Text(text = "You're in Paris",
                  modifier = Modifier.padding(1.dp),
              colorResource(id = R.color.white))
              Text(text = "My Trips",
                  modifier = Modifier.padding(1.dp),
                  colorResource(id = R.color.white))
          }

          LazyRow(
              modifier = Modifier.fillMaxWidth()
          ){
            items(categories) {categories ->
                Card(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = Color(
                        35,
                        143,
                        216,
                        255
                    )
                ) {

                }
            }
          }
      }



  }
}