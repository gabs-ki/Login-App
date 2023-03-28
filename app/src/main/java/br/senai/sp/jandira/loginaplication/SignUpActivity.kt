package br.senai.sp.jandira.loginaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginaplication.components.BottomShape
import br.senai.sp.jandira.loginaplication.components.TopShape
import br.senai.sp.jandira.loginaplication.ui.theme.LoginAplicationTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignUpScreen("Android")
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(name: String) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .background(
                        colorResource(id = R.color.white)
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.sign_up_title),
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.pink),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.create_new_account),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Box (
                    modifier = Modifier.size(100.dp),
                    contentAlignment = Alignment
                        .BottomEnd
                ){
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopEnd),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.dp,
                            brush = Brush.horizontalGradient(listOf(Color.Magenta,Color.White))
                        )
                    ) {

                    }
                    Image(
                        imageVector = Icons.Default.Person,
                        colorFilter = ColorFilter.tint(Color.Magenta),
                        contentDescription = "",
                        modifier = Modifier
                            .size(92.dp)
                            .align(Alignment.Center)
                    )

                   Card(
                       modifier = Modifier
                           .size(30.dp)
                           .align(alignment = Alignment.BottomEnd)

                   ) {

                      Image(
                          painter = painterResource(id = R.drawable.wallpaper),
                          contentDescription = "",
                          modifier = Modifier
                              .size(30.dp)

                      )
                   }

                }
            }

            Spacer(modifier = Modifier.height(50.dp))


            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "",
                        tint = colorResource(id = R.color.pink)
                    )
                    },
                    label = { Text(text = stringResource(id = R.string.username))},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24),
                        contentDescription = "",
                        tint = colorResource(id = R.color.pink)
                    )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.phone))
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "",
                        tint = colorResource(id = R.color.pink)
                    )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_lock_24),
                        contentDescription = "",
                        tint = colorResource(id = R.color.pink)
                    )
                    },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp)
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(checked = false, onCheckedChange = {},
                        modifier = Modifier
                            .width(27.dp)
                            .height(27.dp)
                            .padding(start = 25.dp),

                        )

                    Text(text = stringResource(id = R.string.age_question),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 4.dp))
                }


                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.End
                ) {

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(start = 17.dp, end = 17.dp, top = 20.dp)
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.pink))

                    ) {
                        Text(
                            text = stringResource(id = R.string.create_account),
                            color = colorResource(id = R.color.white)
                        )


                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 31.dp, end = 17.dp)

                    ) {
                        Text(
                            text = stringResource(id = R.string.account_question),
                            color = colorResource(id = R.color.grey),
                            modifier = Modifier
                                .padding(end = 3.dp)
                        )

                        Text(
                            text = stringResource(id = R.string.sign_in_button),
                            color = colorResource(id = R.color.pink),
                            modifier = Modifier
                                .padding(start = 3.dp,end = 3.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        modifier = Modifier
                            .background(
                                colorResource(id = R.color.white)
                            )
                            .fillMaxSize(),
                        verticalAlignment = Alignment.Bottom

                    ) {
                        BottomShape()
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LoginAplicationTheme {
        SignUpScreen("Android")
    }
}