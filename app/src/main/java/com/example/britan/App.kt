package com.example.britan

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()
    NavHost(navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable("quizScreen") { QuizScreen(viewModel, navController) }
        composable("reviewScreen") {
            ReviewScreen(
                correctAnswers = viewModel.correctAnswers,
                wrongAnswers = viewModel.wrongAnswers,
                accuracy = viewModel.calculateAccuracy()
            )
        }
    }
}