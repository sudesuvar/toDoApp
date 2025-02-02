package com.example.todoapp.Pages
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordPage(navController: NavController){
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Spacer(modifier =  Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }

        Spacer(modifier =  Modifier.height(60.dp))

        //Image(painter =  painterResource(id = R.drawable.lock) , contentDescription = "Lock Image", modifier = Modifier.size(250.dp))

        Text(text = "Şifrenizi mi unuttunuz ? ", fontSize = 28.sp , fontWeight = FontWeight.Bold)

        Spacer(modifier =  Modifier.height(4.dp))

        Text(text =  "Aşağıdaki alana aktif kullandığınız bir Email girin.")

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

        Spacer(modifier =  Modifier.height(20.dp))

        Button(onClick ={
            Log.i("Credential", "Email : $email ")
        },  colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.green),
            contentColor = colorResource(R.color.white)
        ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 50.dp)
                .height(50.dp)) {
            Text(text = "Gönder", fontSize = 16.sp)
        }
    }
}