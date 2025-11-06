package com.example.myquestnavigastugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// Import NavHostController tidak diperlukan
import com.example.myquestnavigastugas.R

@Composable
// PERBAIKAN: Sesuaikan nama parameter agar cocok dengan panggilan di Navigasi.kt
fun WelcomeScreen(
    onTampilDataClicked: () -> Unit,
    onFormulirPendaftaranClicked: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Selamat Datang", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "image",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Auliya Fikri Rahmadani", fontSize = 25.sp)
            Text(
                "20230140063", fontSize = 23.sp,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // PERBAIKAN: Hubungkan tombol ke aksi navigasi yang benar
            Button(
                onClick = onFormulirPendaftaranClicked, // Navigasi ke halaman formulir
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text("Buka Formulir Pendaftaran")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // PERBAIKAN: Hubungkan tombol ke aksi navigasi yang benar
            Button(
                onClick = onTampilDataClicked, // Navigasi ke halaman daftar peserta
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text("Lihat Daftar Peserta")
            }
        }
    }
}
