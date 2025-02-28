package com.example.doraclaculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doraclaculadora.ui.theme.DoraclaculadoraTheme


data class BotonModelo(val id: String, var boton: String){}

var botones_a_dibujar= arrayOf(
    BotonModelo("9","9"),
    BotonModelo("8","8"),
    BotonModelo("7","7")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoraclaculadoraTheme {
                Calculadora()
            }
        }
    }
}

@Composable
fun Calculadora() {
    var pantalla_calculadora= remember { mutableStateOf("0") }
    Log.v()
    fun pulsar_voton(id: String){
        when(id){
            "9"->{
                pantalla_calculadora.value=pantalla_calculadora.value+"9"
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Text(text = "Aqui van numeritos", modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color.Blue)
            .height(50.dp),
            textAlign = TextAlign.Right,
        )

        Column(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Boton("9", alPulsar = {})
                Boton("8", alPulsar = {})
                Boton("7", alPulsar = {})
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Boton("6", alPulsar = {})
                Boton("5", alPulsar = {})
                Boton("4", alPulsar = {})
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Boton("3", alPulsar = {})
                Boton("2", alPulsar = {})
                Boton("1", alPulsar = {})
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
               for ( boton_a_dibujar in botones_a_dibujar){
                 Boton(boton_a_dibujar.boton, alPulsar ={})
               }
            }


        }
    }
}

@Composable
fun Boton(etiqueta: String, alPulsar:()-> Unit) {
    Button(onClick = alPulsar)
    {
        Image(painter = painterResource(R.drawable.images),
            contentDescription = "una foto del conde",
            modifier = Modifier.size(25.dp)
        )
        Text(
            etiqueta, modifier = Modifier
                .background(Color.Green)
                .height(10.dp)
                .width(10.dp),
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DoraclaculadoraTheme {
        Calculadora()
    }
}


@Preview(showBackground = true)
@Composable
fun mostrar_boton() {
    DoraclaculadoraTheme {
        Boton("nosequeera", alPulsar = {})
    }
}


