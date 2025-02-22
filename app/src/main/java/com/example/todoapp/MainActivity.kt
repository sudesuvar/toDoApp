package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.Pages.ForgotPasswordPage
import com.example.todoapp.Pages.LoginPage
import com.example.todoapp.Pages.SignupPage
import com.example.todoapp.ui.theme.ToDoAppTheme
import np.com.bimalkafle.todoapp.TodoListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.loginPage, builder = {
                    composable(Routes.loginPage,) {
                        LoginPage(navController, viewModel = AuthViewModel())
                    }
                    composable(Routes.signupPage,) {
                        SignupPage(navController, viewModel = AuthViewModel())
                    }
                    composable(Routes.forgotPasswordPage,) {
                        ForgotPasswordPage(navController)
                    }
                    composable(Routes.TodoListPage,) {
                        TodoListPage(navController , viewModel = todoViewModel)
                    }
                })
            }
        }
    }
}

