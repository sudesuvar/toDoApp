package com.example.todoapp.Pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.AuthState
import com.example.todoapp.AuthViewModel
import com.example.todoapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(viewModel: AuthViewModel){

    val authState = viewModel.authState.observeAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (val currentState = authState.value) {
            is AuthState.Authenticated -> {
                //navController.navigate(Routes.mainScreen)
            }
            is AuthState.Error -> {
                Toast.makeText(context, currentState.message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit // Başka bir durum için işlem yapılmıyor
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        //Image(painter =  painterResource(id = R.drawable.smart) , contentDescription = "Login Image", modifier = Modifier.size(250.dp))

        Text(text = "Tekrar Hoşgeldin", fontSize = 28.sp , fontWeight = FontWeight.Bold)

        Spacer(modifier =  Modifier.height(4.dp))

        Text(text =  "Hesabına Giriş Yap")

        Spacer(modifier =  Modifier.height(20.dp))

        OutlinedTextField(value = email, onValueChange = { email = it} , label = {
            Text(text = "Email")},
            modifier = Modifier.width(width = 350.dp),
            leadingIcon = {
                Icon(
                    Icons.Default.Email, contentDescription = "Password Icon" ,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(R.color.orange),
                unfocusedBorderColor = colorResource(R.color.green)),
        )

        Spacer(modifier =  Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = { password = it} , label = {
            Text(text = "Şifre")
        },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.width(width = 350.dp),
            leadingIcon = {
                Icon(
                    Icons.Default.Lock, contentDescription = "Password Icon" ,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(R.color.orange),
                unfocusedBorderColor = colorResource(R.color.green)),
        )

        Spacer(modifier =  Modifier.height(36.dp))

        Button(onClick ={
            Log.i("Credential", "Email : $email Password : $password")
            viewModel.login(email, password)
        },  colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.green),
            contentColor = colorResource(R.color.white)),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 50.dp)
                .height(50.dp)) {
            Text(text = "Giriş", fontSize = 16.sp)
        }

        Spacer(modifier =  Modifier.height(32.dp))

        Text(text = "Şifremi Unuttum" , modifier = Modifier.clickable {
        })

        Spacer(modifier =  Modifier.height(16.dp))

        Text(text = "Bir Hesap Oluştur." , modifier = Modifier.clickable {
        })

        Spacer(modifier =  Modifier.height(32.dp))

        Spacer(modifier =  Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter =  painterResource(id = R.drawable.google) , contentDescription = "Google Image", modifier = Modifier.size(50.dp).clickable {

            })
            Spacer(modifier =  Modifier.width(16.dp))

            Image(painter =  painterResource(id = R.drawable.linkedin) , contentDescription = "Linkedn Image", modifier = Modifier.size(50.dp).clickable {

            })
        }

    }

}