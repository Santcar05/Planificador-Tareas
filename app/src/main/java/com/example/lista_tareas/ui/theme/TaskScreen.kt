package com.example.lista_tareas.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista_tareas.R

@Composable
fun Header(
    tituloSeccion: String,
    modifier: Modifier = Modifier,
    colorFuente: Color = Color.White,
    colorFondo: Color = MaterialTheme.colorScheme.primary
){
    Row(
        modifier = Modifier
            .background(colorFondo)
            .padding(30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,

    ){
        Text(text = tituloSeccion,
                color = colorFuente,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
    }

}

@Composable
@Preview(showBackground = true)
fun HeaderPreview(
){
    Header(stringResource(R.string.mis_tareas), modifier = Modifier.padding(8.dp),colorFuente = Color.White, colorFondo = MaterialTheme.colorScheme.primary)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf(text) }

    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = { newText ->
            query = newText
            onTextChange(newText)
        },
        onSearch = { searchQuery ->
            onSearch(searchQuery)
            expanded = false
        },
        active = expanded,
        onActiveChange = { expanded = it },
        placeholder = { Text("Search") }
    ) {
        // Search suggestions would go here
    }
}

@Composable
@Preview(showBackground = true)
fun SearchTextFieldPreview(){
    SearchTextField(
        text = "",
        onTextChange = {},
        onSearch = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .semantics { traversalIndex = 1F }
    )
}


@Composable
fun CardTask(){
    //Variables de estado

    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .semantics { traversalIndex = 2F}
    ) {
        //FONDO----
        //Fin Background---
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Trabajar:)",
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun CardTaskPreview(){
    CardTask()
}

@Composable
fun TaskScreen(){
    //Variables de estado

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        //FONDO----
        //Fin Background---
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
        ){
            Header(stringResource(R.string.mis_tareas), modifier = Modifier.padding(8.dp),colorFondo = MaterialTheme.colorScheme.primary)
            SearchTextField(
                text = "",
                onTextChange = {},
                onSearch = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .semantics { traversalIndex = 1F }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TaskScreenPreview(){
    TaskScreen()
}

