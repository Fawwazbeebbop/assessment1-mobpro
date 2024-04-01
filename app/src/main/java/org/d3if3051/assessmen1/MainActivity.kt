package org.d3if3051.assessmen1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if3051.assessmen1.ui.theme.Assessmen1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assessmen1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(content: @Composable (Modifier) -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
               )
        }
    ) { padding ->
        content(Modifier.padding(padding))
    }
}

@Composable
fun WelcomeScreen(){
    MainScreen { modifier ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(13.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.size(120.dp).padding(bottom = 16.dp),
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "Wallet Image",
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = (R.string.introduction)),
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = stringResource(R.string.start))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Assessmen1Theme {
        WelcomeScreen()
    }
}