package com.example.seuapp.data.model

data class QuestionResponse(
    val response_code: Int,
    val results: List<Question>
)

data class Question(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: List<String>
)