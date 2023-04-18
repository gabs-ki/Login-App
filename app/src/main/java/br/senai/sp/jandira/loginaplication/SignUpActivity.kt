package br.senai.sp.jandira.loginaplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginaplication.components.BottomShape
import br.senai.sp.jandira.loginaplication.components.TopShape
import br.senai.sp.jandira.loginaplication.model.User
import br.senai.sp.jandira.loginaplication.repository.UserRepository
import br.senai.sp.jandira.loginaplication.ui.theme.LoginAplicationTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy

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

@SuppressLint("RememberReturnType")
@Composable
fun SignUpScreen(name: String) {

    var userNameState by rememberSaveable {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(value = false)
    }

    //Obter foto da galeria de imagens
    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //Criar o objeto que abrirá a galeria o retornára,
    // a Uri da imagem selecionada

    val laucher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        photoUri = it
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(photoUri).build()
    )

    var context = LocalContext.current

    
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier

                .background(color = Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //Carinha de cima
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

            Spacer(modifier = Modifier.height(80.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .weight(weight = 1f)
                .verticalScroll(rememberScrollState())) {
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
                            Image(
                                painter = painter,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(92.dp)
                                    .align(Alignment.Center),
                                contentScale = ContentScale.Crop
                            )
                        }



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
                                    .clickable {
                                        laucher.launch("image/*")
                                    }
                            )
                        }

                    }
                }

                Spacer(modifier = Modifier.height(50.dp))


                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    OutlinedTextField(
                        value =userNameState,
                        onValueChange = {userNameState = it},
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
                        value = phoneState,
                        onValueChange = {phoneState = it },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = "",
                            tint = colorResource(id = R.color.pink)
                        )
                        },
                        label = {
                            Text(text = stringResource(id = R.string.phone))
                        },
                        visualTransformation = VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
                    OutlinedTextField(
                        value = emailState,
                        onValueChange = {emailState = it},
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "",
                            tint = colorResource(id = R.color.pink)
                        )
                        },
                        label = {
                            Text(text = stringResource(id = R.string.email))
                        },
                        visualTransformation = VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 17.dp, end = 17.dp, bottom = 10.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
                    OutlinedTextField(
                        value = passwordState,
                        onValueChange = {passwordState = it},
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


                    //CheckBox
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(checked = over18State, onCheckedChange = {over18State = it},
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


                    //Botao
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.End
                    ) {

                        Button(
                            onClick = {
                                      userSave(
                                          context = context,
                                          email = emailState,
                                          username = userNameState,
                                          phone = phoneState,
                                          password = passwordState,
                                          isOver18 = over18State
                                      )
                            },
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

                        //Texto de baixo
                        Row(
                            modifier = Modifier
                                .padding(top = 31.dp, end = 17.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = stringResource(id = R.string.account_question),
                                color = colorResource(id = R.color.grey),
                                modifier = Modifier
                                    .padding(end = 3.dp)
                            )

                            TextButton(
                                onClick = {
                                    var openSignIn = Intent(context, MainActivity::class.java)
                                    context.startActivity(openSignIn)
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.sign_in_button),
                                    color = colorResource(id = R.color.pink),
                                    modifier = Modifier
                                        .padding(start = 3.dp,end = 3.dp),
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }


                    }

                }


            }

            //Carinha de baixo
            Row(
                modifier = Modifier
                    .background(
                        colorResource(id = R.color.white)
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom

            ) {
                BottomShape()
            }
        }
    }
}

fun userSave(
    context: Context,
    email: String,
    username: String,
    phone: String,
    password: String,
    isOver18: Boolean
) {
    val userRepository = UserRepository(context = context)


    //Recuperando no banco um usuário que
    //tenha o emeil informado
    var user = userRepository.findUserByEmail(email = email)

    //Se user for null, gravamos o novo usuário,
    //senão, avisamos que o usuário já existe.

    if(user == null) {
        val newUser = User(
            userName = username,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver18
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context,
            "User already exists!!",
            Toast.LENGTH_SHORT
        ).show()

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LoginAplicationTheme {
        SignUpScreen("Android")
    }
}