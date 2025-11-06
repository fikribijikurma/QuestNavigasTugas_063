package com.example.myquestnavigastugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myquestnavigastugas.view.FormulirPendaftaran
import com.example.myquestnavigastugas.view.TampilData
import com.example.myquestnavigastugas.view.WelcomeScreen

// Enum untuk rute/halaman, sudah benar
enum class PengelolaHalaman {
    Welcome,
    ListPeserta,
    Formulir
}

// Mengubah nama fungsi menjadi lebih deskriptif dan mengikuti pola contoh
@Composable
fun AplikasiPendaftaran(
    navController: NavHostController = rememberNavController()
) {
    // Membungkus NavHost di dalam Scaffold seperti pada contoh
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Welcome.name,
            // Menerapkan padding dari Scaffold ke NavHost
            modifier = Modifier.padding(innerPadding)
        ) {
            // Rute untuk Halaman Welcome
            composable(route = PengelolaHalaman.Welcome.name) {
                WelcomeScreen(
                    onTampilDataClicked = { navController.navigate(PengelolaHalaman.ListPeserta.name) },
                    onFormulirPendaftaranClicked = { navController.navigate(PengelolaHalaman.Formulir.name) }
                )
            }

            // Rute untuk Halaman List Peserta (TampilData)
            composable(route = PengelolaHalaman.ListPeserta.name) {
                TampilData(
                    // Mengirim navController langsung sudah cukup untuk kebutuhan navigasi kembali
                    navController = navController
                )
            }

            // Rute untuk Halaman Formulir
            composable(route = PengelolaHalaman.Formulir.name) {
                FormulirPendaftaran(
                    // Aksi setelah tombol submit ditekan
                    onSubmitClicked = {
                        // Navigasi ke halaman ListPeserta setelah submit
                        navController.navigate(PengelolaHalaman.ListPeserta.name)
                    },
                    // Aksi untuk tombol kembali (jika Anda menambahkannya)
                    onBackPressed = {
                        // Kembali ke halaman sebelumnya dalam tumpukan navigasi (backstack)
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
