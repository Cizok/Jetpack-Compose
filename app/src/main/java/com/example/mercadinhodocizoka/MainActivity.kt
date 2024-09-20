package com.example.mercadinhodocizoka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mercadinhodocizoka.ui.theme.MercadinhodoCizokaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadinhodoCizokaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaCompras()
                }
            }
        }
    }
}

@Composable
fun ListaCompras() {
    var produto by remember { mutableStateOf("") }
    val ListaCompras = remember {mutableStateListOf<String>() }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BasicTextField(value = produto,  onValueChange = {produto.value = it},
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp))
    }
    Row (
        modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(onClick ={
            if (produto.isNotBlank()){
                ListaCompras.add(produto)
                produto = ""
            }
        }){
            Text(text = "Adicionar")
        }

        Button(onClick ={
                ListaCompras.remove(produto)
                produto = ""

        }){
            Text(text = "Remover")
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Carrinho: ")

    if (ListaCompras.isEmpty()){
        Text("Nenhum item no carrinho")
    } else {
        Column {
            ListaCompras.forEach{ item -> Text(text = item)}
        }
    }
}


