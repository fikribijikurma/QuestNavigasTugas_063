package com.example.myquestnavigastugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myquestnavigastugas.R

@Composable
// PERBAIKAN 1: Sesuaikan parameter fungsi agar cocok dengan panggilan di Navigasi.kt
fun FormulirPendaftaran(
    onSubmitClicked: () -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier // Tambahkan nilai default
) {
    // === State ===
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var alamat by remember { mutableStateOf(TextFieldValue("")) }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }

    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val paddingLarge = dimensionResource(id = R.dimen.padding_large)
    val buttonHeight = dimensionResource(id = R.dimen.button_height)

    // === Background utama ===
    Surface(
        color = Color(0xFFF6ECFF),
        modifier = modifier.fillMaxSize() // Gunakan modifier dari parameter
    ) {
        Column(
            // PERBAIKAN 2: Tambahkan verticalScroll agar konten tidak terpotong
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color(0xFFB56BFF))
                    .padding(vertical = paddingLarge)
            ) {
                // PERBAIKAN 3: Tambahkan tombol kembali (IconButton)
                IconButton(
                    onClick = onBackPressed,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.kembali),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(R.string.FormulirPendaftaran),
                    fontSize = dimensionResource(id = R.dimen.font_title).value.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(paddingMedium))
            // ===== CARD FORM =====
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = paddingMedium),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingMedium)
                        .fillMaxWidth()
                ) {
                    // ===== NAMA LENGKAP =====
                    Text("NAMA LENGKAP", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        placeholder = { Text("Isian nama lengkap") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = paddingSmall)
                    )
                    Spacer(modifier = Modifier.height(paddingMedium))

                    // ===== JENIS KELAMIN =====
                    Text("JENIS KELAMIN", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(paddingSmall))
                    Column(verticalArrangement = Arrangement.spacedBy(paddingSmall)) {
                        listOf("Laki-laki", "Perempuan").forEach { opsi ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = jenisKelamin == opsi,
                                    onClick = { jenisKelamin = opsi }
                                )
                                Text(opsi)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(paddingMedium))

                    // ===== STATUS PERKAWINAN =====
                    Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(paddingSmall))
                    Column(verticalArrangement = Arrangement.spacedBy(paddingSmall)) {
                        listOf("Janda", "Lajang", "Duda").forEach { opsi ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = statusPerkawinan == opsi,
                                    onClick = { statusPerkawinan = opsi }
                                )
                                Text(opsi)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(paddingMedium))

                    // ===== ALAMAT =====
                    Text("ALAMAT", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        placeholder = { Text("Alamat lengkap") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = paddingSmall)
                    )

                    Spacer(modifier = Modifier.height(paddingLarge))
                    // ===== BUTTON SUBMIT =====
                    Button(
                        // PERBAIKAN 4: Hubungkan tombol dengan aksi navigasi
                        onClick = onSubmitClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A2BE2)),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(buttonHeight)
                    ) {
                        Text(stringResource(R.string.Submit), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
            // Memberi jarak di bawah agar nyaman di-scroll
            Spacer(modifier = Modifier.height(paddingLarge))
        }
    }
}
