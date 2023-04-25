package br.senai.sp.jandira.loginaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginaplication.dao.repository.CategorieRepository
import br.senai.sp.jandira.loginaplication.model.Category
import br.senai.sp.jandira.loginaplication.ui.theme.LoginAplicationTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAplicationTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()

            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreen() {

    HomeScreen(categories = CategorieRepository.getCategoriesList())
}

@Composable
fun HomeScreen(categories: List<Category>) {
    Scaffold( floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(text = "+")
            Icon(
                imageVector = Icons.Default.Add ,
                contentDescription = ""
            )
        }
    }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            color = colorResource(id = R.color.milk)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    backgroundColor = Color.Magenta,
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paris),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.categories),
                        modifier = Modifier.padding( start = 17.dp, top = 15.dp, bottom = 5.dp)
                    )
                }



                LazyRow(
                    modifier = Modifier
                        .padding(start = 15.dp)
                ) {
                    items(categories) { categories ->

                        Card(
                            modifier = Modifier
                                .size(200.dp, 80.dp)
                                .padding(4.dp),
                            backgroundColor = Color(207,6,240)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Icon(
                                    painter = categories.image?: painterResource(id = R.drawable.wallpaper),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(40.dp),
                                    tint = Color.White
                                )

                                Text(
                                    text = categories.name,
                                    color = Color.White
                                )
                            }

                        }

                    }

                }



                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(380.dp)
                        .padding(10.dp)
                        .background(
                            color = colorResource(id = R.color.white),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    shape = RoundedCornerShape(15.dp),
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.search_your_destiny),
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    },
                    colors = TextFieldDefaults
                        .outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White
                        ),


                    )


                LazyColumn() {
                    items(10){
                        Card(
                            modifier = Modifier
                                .size(400.dp, 200.dp)
                                .padding(4.dp),
                            backgroundColor = Color.Blue
                        ) {
                            Text(text = "Card #$it")
                        }
                    }
                }
            }


        }
    }

}


//
//Box(
//modifier = Modifier
//.fillMaxWidth()
//.height(300.dp),
//) {
//    Image(
//        painter = painterResource(id = R.drawable.paris),
//        contentDescription = ""
//    )
//}
//
//Column(
//modifier = Modifier
//.fillMaxSize(),
//verticalArrangement = Arrangement.SpaceBetween
//) {
//}
//
//Column(
//horizontalAlignment = Alignment.End,
//modifier = Modifier
//.padding(13.dp)
//) {
//
//    Column(
//        modifier = Modifier
//            .height(62.dp)
//            .width(62.dp)
//            .background(
//                colorResource(id = R.color.white),
//                shape = RoundedCornerShape(50)
//            ),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.susanna_profile),
//            contentDescription = "",
//            modifier = Modifier
//                .clip(shape = RoundedCornerShape(50.dp))
//                .height(57.dp)
//                .width(57.dp)
//        )
//    }
//
//    Text(text = "Susanna Halft")
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp),
//        verticalArrangement = Arrangement.Bottom
//    ) {
//        Text(
//            text = "You're in Paris",
//            modifier = Modifier.padding(1.dp),
//            colorResource(id = R.color.white)
//        )
//        Text(
//            text = "My Trips",
//            modifier = Modifier.padding(1.dp),
//            colorResource(id = R.color.white)
//        )
//    }
//
//    LazyRow(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items(categories) { categories ->
//            Card(
//                modifier = Modifier.fillMaxSize(),
//                backgroundColor = Color(
//                    35,
//                    143,
//                    216,
//                    255
//                )
//            ) {
//
//            }
//        }
//    }
//}