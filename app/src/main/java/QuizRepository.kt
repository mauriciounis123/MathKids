package com.example.seuapp.data

import br.com.softwareminas.mathkids.data.api.TriviaApi
import com.example.seuapp.data.model.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuizRepository {

    private val triviaApi: TriviaApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com/api.php?amount=10&category=19&difficulty=easy&type=multiple")
            .addConverterFactory(GsonConverterFactory.create())
            .build().also {

                triviaApi= it.create(TriviaApi::class.java)
            }
    }

    suspend fun fetchQuestions(amount: Int = 10, difficulty: String = "easy"): List<Question> =
        withContext(Dispatchers.IO) {
            val response = triviaApi.getQuestions(amount, 19, difficulty, "multiple")
            return@withContext response.results
        }
}