package com.example.britan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReviewScreen(
    correctAnswers: List<Pair<String, String>>,
    wrongAnswers: List<Pair<String, String>>,
    accuracy: Float
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // 画面中央に配置
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Review Your Answers", style = MaterialTheme.typography.h5)


            Spacer(modifier = Modifier.height(16.dp))


            Text("Correct Answers:")
            correctAnswers.forEach {
                Text("✅ ${it.first} -> ${it.second}")
            }


            Spacer(modifier = Modifier.height(16.dp))


            Text("Wrong Answers:")
            wrongAnswers.forEach {
                Text("❌ ${it.first} -> Correct: ${it.second}")
            }


            Spacer(modifier = Modifier.height(16.dp))


            CircularProgressIndicator(progress = accuracy / 100f, modifier = Modifier.size(100.dp))
            Text("Your accuracy: %.2f%%".format(accuracy))


            Spacer(modifier = Modifier.height(16.dp))


            Button(onClick = { /* Restart the quiz */ }) {
                Text("Restart Quiz")
            }
        }
    }
}