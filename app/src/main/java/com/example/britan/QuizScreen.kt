package com.example.britan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun QuizScreen(viewModel: QuizViewModel, navController: NavHostController) {
    var currentIndex by remember { mutableStateOf(0) }
    var userAnswer by remember { mutableStateOf("") }

    val totalQuestions = viewModel.questions.size
    val progress = (currentIndex.toFloat() / totalQuestions.toFloat()) * 100

    if (currentIndex < totalQuestions) {
        val question = viewModel.questions[currentIndex]

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // 画面中央に配置
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "American English: ${question.first}", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = userAnswer,
                    onValueChange = { userAnswer = it },
                    label = { Text("Enter British English") },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(progress = progress / 100f, modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp))

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        viewModel.submitAnswer(question.first, userAnswer, question.second)
                        currentIndex++
                        userAnswer = ""
                    },
                    enabled = userAnswer.isNotEmpty()
                ) {
                    Text("Answer")
                }
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { navController.navigate("reviewScreen") }) {
                Text("Review Answers")
            }
        }
    }
}