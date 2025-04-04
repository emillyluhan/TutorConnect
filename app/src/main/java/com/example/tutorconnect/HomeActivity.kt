package com.example.tutorconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorconnect.ui.theme.TutorConnectTheme
import androidx.compose.ui.tooling.preview.Preview

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorConnectTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp), // Mayor padding para centrar el contenido
        horizontalAlignment = Alignment.CenterHorizontally // Centrado horizontal
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hola Emilly!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6A1B9A)
        )
        Text(
            text = "Buenos días",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Programar un nuevo evento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta de Bienvenida
        Card(
            shape = RoundedCornerShape(12.dp),
            border = ButtonDefaults.outlinedButtonBorder,
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bienvenida),
                    contentDescription = "Bienvenida",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Bienvenida!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6A1B9A)
                    )
                    Text(
                        text = "Vamos a programar tus próximas tutorías",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Módulos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp), // Mayor separación
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ModuleButton("Comunicados")
            ModuleButton("Programar Tutorías")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Barra de Navegación
        BottomNavigationBar()
    }
}

@Composable
fun ModuleButton(title: String) {
    Box(
        modifier = Modifier
            .size(160.dp) // Tamaño más grande
            .background(Color(0xFF6A1B9A), RoundedCornerShape(12.dp))
            .clickable { /* Acción del botón */ },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            color = Color.White
        )
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(2.dp, Color(0xFF6A1B9A), RoundedCornerShape(12.dp))
            .padding(16.dp), // Mayor padding
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Inicio",
            tint = Color.Unspecified,
            modifier = Modifier.size(36.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_busqueda),
            contentDescription = "Buscar",
            tint = Color.Unspecified,
            modifier = Modifier.size(36.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_userhome), // Cambiado
            contentDescription = "Perfil",
            modifier = Modifier
                .size(36.dp)
                .background(Color.Gray, shape = CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TutorConnectTheme {
        HomeScreen()
    }
}

