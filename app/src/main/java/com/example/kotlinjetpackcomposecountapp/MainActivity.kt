package com.example.kotlinjetpackcomposecountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
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
                // A surface container using the 'background' color from the theme
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
        Column {
//            SimpleFilledTextFieldSample()
            Text(
                text = "Count: ${viewModel.getCount()}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray, // 色を変える
                fontSize = 18.sp
            )
        }


        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CounterButton(
                text = "+",
                onClick = { viewModel.increment() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            CounterButton(
                text = "-",
                onClick = { viewModel.decrement() }
            )
            Spacer(modifier = Modifier.width(8.dp))
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
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
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