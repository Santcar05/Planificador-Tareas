package com.example.lista_tareas.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.example.lista_tareas.R
import com.example.lista_tareas.data.local.local_task_provider

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
fun CardTask(
    nombreTarea: String = "Tarea",
    fechaTarea: String = "01/01/2023",
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .semantics { traversalIndex = 1F },
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Título con límite de espacio
            Text(
                text = nombreTarea,
                modifier = Modifier
                    .weight(1f) // ocupa el espacio restante pero limitado
                    .padding(8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                maxLines = 1, // solo una línea
                overflow = TextOverflow.Ellipsis // agrega "..."
            )

            // Fecha e ícono de fecha
            Row(
                modifier = Modifier.padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.DateRange,
                    contentDescription = "DateRange",
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = fechaTarea,
                    modifier = Modifier.padding(4.dp),
                    maxLines = 1
                )
            }

            // Ícono de eliminar (siempre visible)
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.Delete,
                contentDescription = "Delete",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CardTaskPreview(){
    val example = local_task_provider.taskList[0]
    Lista_TareasTheme {
        CardTask(example.nombre, example.fechaMaxima)
    }
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
            LazyColumn{
                items(local_task_provider.taskList.size){
                    CardTask(local_task_provider.taskList[it].nombre, local_task_provider.taskList[it].fechaMaxima)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TaskScreenPreview(){
    Lista_TareasTheme {
        TaskScreen()
    }
}

