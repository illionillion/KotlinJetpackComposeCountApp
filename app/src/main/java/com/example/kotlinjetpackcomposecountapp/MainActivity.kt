package com.example.kotlinjetpackcomposecountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinjetpackcomposecountapp.ui.theme.KotlinJetpackComposeCountAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // setContent内でComposable関数を受け取る、Composable関数の中からComposable関数を呼び出せない。
            KotlinJetpackComposeCountAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {

    val viewModel: CounterViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Count: ${viewModel.getCount()}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.DarkGray, // 色を変える
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CounterButton(
                text = "Plus",
                onClick = { viewModel.increment() }
            )
            CounterButton(
                text = "Minus",
                onClick = { viewModel.decrement() }
            )
            CounterButton(
                text = "Reset",
                onClick = { viewModel.reset() }
            )
        }

    }
}

@Composable
fun CounterButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Icon(
            when (text) {
              "Plus" -> {
                  Icons.Filled.KeyboardArrowUp
              }
              "Minus" -> {
                  Icons.Filled.KeyboardArrowDown
              }
              "Reset" -> {
                  Icons.Filled.Clear
              }
              else -> {
                  Icons.Filled.Star
              }
            },
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ImageSample() {
    val imageModifier = Modifier
        .size(200.dp)
//        .fillMaxWidth(0.5f) // 画面の半分のサイズ
        .border(BorderStroke(3.dp, Color.Cyan))

    Image(painter = painterResource(R.drawable.my_profile_picture), contentDescription = "サンプル画像", modifier = imageModifier)
}

@Composable
fun ImageCircleSample() {
    val imageModifier = Modifier
        .size(200.dp)
        .clip(CircleShape) // 円にする

    Image(painter = painterResource(R.drawable.my_profile_picture), contentDescription = "サンプル画像", modifier = imageModifier)
}

@Composable
fun ImageRoundedCornerShapeSample() {
    val imageModifier = Modifier
        .size(200.dp)
        .clip(RoundedCornerShape(24.dp)) // 角を丸くする

    Image(painter = painterResource(R.drawable.my_profile_picture), contentDescription = "サンプル画像", modifier = imageModifier)
}

@Preview(showBackground = true)
@Composable
fun PreviewImageSamples() {
    Column {
        ImageSample()
        ImageCircleSample()
        ImageRoundedCornerShapeSample()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Welcome Summer") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Greet Label") }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterButton () {
    CounterButton(
        text = stringResource(R.string.hello_text), // リソースファイルから文字列を取得（ハードコードを避けるため）
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterApp() {
    CounterApp()
}