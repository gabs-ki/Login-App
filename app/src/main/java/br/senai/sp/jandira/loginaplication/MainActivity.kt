package br.senai.sp.jandira.loginaplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.senai.sp.jandira.loginaplication.repository.UserRepository
import br.senai.sp.jandira.loginaplication.ui.theme.LoginAplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAplicationTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }




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
            Spacer(modifier = Modifier.height(87.dp))
            //Login
            Column(


            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 48.sp,
                    color = colorResource(id = R.color.pink),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 17.dp)
                )
                Text(
                    text = stringResource(id = R.string.please),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier.padding(start = 17.dp)
                )
            }

            Spacer(modifier = Modifier.height(87.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedTextField(
                    value = emailState,
                    onValueChange = {
                        emailState = it
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "",
                            tint = colorResource(id = R.color.pink)
                        )
                    },
                    label = { Text(text = stringResource(id = R.string.email)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(17.dp),
                    shape = RoundedCornerShape(16.dp)
                )
                OutlinedTextField(
                    value = passwordState,
                    onValueChange = {
                        passwordState = it
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = "",
                            tint = colorResource(id = R.color.pink)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibilityState = !passwordVisibilityState
                        }) {
                            Icon(
                                imageVector = if (passwordVisibilityState)
                                    Icons.Default.VisibilityOff
                                else
                                    Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    visualTransformation =
                    if(!passwordVisibilityState)
                        PasswordVisualTransformation()
                    else
                        VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp),
                    shape = RoundedCornerShape(16.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            authenticate(emailState, passwordState, context)
                        },
                        modifier = Modifier
                            .padding(top = 31.dp, end = 17.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.pink))

                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            color = colorResource(id = R.color.white)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                            contentDescription = "",
                            tint = colorResource(id = R.color.white),
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 31.dp, end = 17.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = stringResource(id = R.string.account),
                            color = colorResource(id = R.color.grey),
                            modifier = Modifier
                                .padding(end = 3.dp)
                        )
                        TextButton(
                            onClick = {
                                var openSignUp = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openSignUp)
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_up),
                                color = colorResource(id = R.color.pink),
                                modifier = Modifier
                                    .padding(start = 3.dp, end = 3.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }

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

fun authenticate(
    email: String,
    password: String,
    context: Context
) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(
        email,
        password
    )

    if (user != null) {
        val openHomeActivity = Intent(context, HomeActivity::class.java)
        context.startActivity(openHomeActivity)
    }

}
