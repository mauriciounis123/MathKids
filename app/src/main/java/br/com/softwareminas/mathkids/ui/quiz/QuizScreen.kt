package com.example.seuapp.ui.quiz

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.material.Text
import com.example.seuapp.data.QuizRepository
import com.example.seuapp.data.model.Question
import com.example.seuapp.ui.components.QuestionCard
import kotlinx.coroutines.launch

@Composable
fun QuizScreen() {
    var questions by remember { mutableStateOf<List<Question>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()
    val quizRepository = QuizRepository()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            questions = quizRepository.fetchQuestions()
        }
    }
    LazyColumn {
        items(questions) { question ->
            QuestionCard(question)
        }
    }
}