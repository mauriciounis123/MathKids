package br.com.softwareminas.mathkids

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seuapp.data.model.Question

@Composable
fun QuestionCard(question: Question) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = question.question)

            val options = question.incorrect_answers.toMutableList()
            options.add(question.correct_answer)
            options.shuffle()

            options.forEach { option ->
                Button(onClick = { /*TODO*/ }) {
                    Text(text = option)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}