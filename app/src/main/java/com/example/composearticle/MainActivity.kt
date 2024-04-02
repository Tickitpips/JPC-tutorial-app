package com.example.composearticle

import android.os.Bundle
import android.view.Display
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayArticle()
                }
            }
        }
    }
}

@Composable
fun DisplayArticle(){
//The DisplayArticle function calls the tutorial screen function with the following resources as parameters
    TutorialScreen(
        title = stringResource(R.string.title_jpc_tutorial), //here, I created string resources
        jpcDef = stringResource(R.string.jpc_definition),
        tutBody = stringResource(R.string.tutorial_body),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun TutorialScreen(
    //Definition of variables as passed in the TutorialScreen function above
    title: String,
    jpcDef: String,
    tutBody: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
){
    //Create a column to display the image and texts
    Column(modifier = modifier){
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = jpcDef,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 24.sp
        )
        Text(
            text = tutBody,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ComposeArticleTheme {
        DisplayArticle()
    }
}

class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalse(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

//Refactored code to include generics
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main(){
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}

enum class Difficulty{
    EASY, MEDIUM, HARD
}

class Question2<T>(
    val questionText:String,
    val answer: T,
    val difficulty: Difficulty
)

//fun main using enum
fun main2(){
    val question1 = Question2<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question2<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question2<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
}