package org.d3if3051.assessmen1.ui.screen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3051.assessmen1.R
import org.d3if3051.assessmen1.navigation.ScreenApp
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
                              imageVector = Icons.Filled.Home,
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
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions ={
                    IconButton(onClick = {
                        navController.navigate(ScreenApp.List.route)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.List,
                            contentDescription = stringResource(R.string.history_button),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ){ padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier){
    var expense1 by rememberSaveable { mutableStateOf("") }
    var expError1 by rememberSaveable { mutableStateOf(false) }

    var expense2 by rememberSaveable { mutableStateOf("") }
    var expError2 by rememberSaveable { mutableStateOf(false) }

    var expense3 by rememberSaveable { mutableStateOf("") }
    var expError3 by rememberSaveable { mutableStateOf(false) }

    val radioOptions = listOf(
        stringResource(id = R.string.period_1),
        stringResource(id = R.string.period_2)
    )
    var time by rememberSaveable { mutableStateOf(radioOptions[0]) }

    var mean by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Column (
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment =Alignment.CenterHorizontally

    ){
        Text(
            text = stringResource(id = R.string.description),
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = expense1,
            onValueChange = {
                expense1 = it
                expError1 = false
            },
            label ={ Text(text = stringResource(R.string.expense_1)) },
            isError = expError1,
            trailingIcon = { IconPicker(expError1, "IDR" ) },
            supportingText = { ErrorHint(expError1) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = expense2,
            onValueChange = {
                expense2 = it
                expError2 = false
            },
            label ={ Text(text = stringResource(R.string.expense_2)) },
            isError = expError2,
            trailingIcon = { IconPicker(expError2, "IDR" ) },
            supportingText = { ErrorHint(expError2) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = expense3,
            onValueChange = {
                expense3 = it
                expError3 = false
            },
            label ={ Text(text = stringResource(R.string.expense_3)) },
            isError = expError3,
            trailingIcon = { IconPicker(expError3, "IDR" ) },
            supportingText = { ErrorHint(expError3) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row (
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ){
            radioOptions.forEach{ text ->
                TimeInterval(
                    label = text,
                    isSelected = time == text,
                    modifier = Modifier
                        .selectable(
                            selected = time == text,
                            onClick = { time = text },
                            role = Role.RadioButton
                        )
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {
                    expense1 = ""
                    expense2 = ""
                    expense3 = ""
                    time = ""
                    mean = ""
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .absolutePadding(right = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.reset_button))
            }
            Button(
                onClick = {
                    if (expense1.isEmpty() || expense2.isEmpty() || expense3.isEmpty()){
                        expError1 = expense1.isEmpty()
                        expError2 = expense2.isEmpty()
                        expError3 = expense3.isEmpty()
                    }else{
                        mean = ((expense1.toDouble() + expense2.toDouble() + expense3.toDouble()) / 3).toString()
                    }
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .absolutePadding(left = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.count))
            }
        }
        Text(text = stringResource(R.string.average) + ": $mean IDR", modifier = Modifier.padding(top = 8.dp))
        
        Button(onClick = {
            if(expense1.isEmpty() || expense2.isEmpty() || expense3.isEmpty()){
                expError1 = expense1.isEmpty()
                expError2 = expense2.isEmpty()
                expError3 = expense3.isEmpty()
            }else {
                shareData(
                    context = context,
                    message = context.getString(R.string.share_button,
                        expense1, expense2, expense3, mean)
                )}
             },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(text = stringResource(R.string.share))
        }
        Text(text = stringResource(R.string.copyright), modifier = Modifier.padding(top = 8.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun TimeInterval(label: String, isSelected: Boolean, modifier: Modifier){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun IconPicker(error: Boolean, unit: String){
    if (error){
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    }else{
        Text(text = unit)
    }
}

@Composable
fun ErrorHint(error: Boolean){
    if (error){
        Text(text = stringResource(R.string.input_invalid))
    }
}

private fun shareData(context: Context, message: String){
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null){
        context.startActivity(shareIntent)
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