package org.d3if3051.assessmen1.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3051.assessmen1.R
import org.d3if3051.assessmen1.ui.theme.Assessmen1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                      IconButton(onClick = { navController.popBackStack() }) {
                          Icon(
                              imageVector = Icons.Filled.ArrowBack,
                              contentDescription = stringResource(R.string.back_button),
                              tint = MaterialTheme.colorScheme.primary
                          )
                      }           
                },
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =MaterialTheme.colorScheme.primary
                )
            )
        }
    ){ padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = stringResource(id = R.string.description),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AppScreenPreview() {
    Assessmen1Theme {
        AppScreen(rememberNavController())
    }
}