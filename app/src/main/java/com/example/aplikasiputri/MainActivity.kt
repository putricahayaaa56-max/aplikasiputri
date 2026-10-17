package com.example.aplikasiputri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Cream = Color(0xFFFFF7F0)
private val Pink = Color(0xFFE887A5)
private val Dark = Color(0xFF49313D)
private val SoftPink = Color(0xFFFFE4EC)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MengenalLelakiApp()
            }
        }
    }
}

@Composable
fun MengenalLelakiApp() {
    var halaman by remember { mutableStateOf("Beranda") }

    Scaffold(
        containerColor = Cream,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                NavigationBarItem(
                    selected = halaman == "Beranda",
                    onClick = { halaman = "Beranda" },
                    icon = { Text("⌂", fontSize = 23.sp) },
                    label = { Text("Beranda") }
                )
                NavigationBarItem(
                    selected = halaman == "Karakter",
                    onClick = { halaman = "Karakter" },
                    icon = { Text("♡", fontSize = 23.sp) },
                    label = { Text("Karakter") }
                )
                NavigationBarItem(
                    selected = halaman == "Kuis",
                    onClick = { halaman = "Kuis" },
                    icon = { Text("✎", fontSize = 23.sp) },
                    label = { Text("Kuis") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            when (halaman) {
                "Beranda" -> Beranda(
                    onKarakter = { halaman = "Karakter" },
                    onKuis = { halaman = "Kuis" }
                )
                "Karakter" -> HalamanKarakter()
                "Kuis" -> HalamanKuis()
            }
        }
    }
}

@Composable
fun Beranda(
    onKarakter: () -> Unit,
    onKuis: () -> Unit
) {
    Text("MENGENAL LELAKI ♡",
        color = Pink,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(Modifier.height(24.dp))

    Text(
        "Kenali karakternya,\nPahami sikapnya.",
        fontSize = 30.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight.Bold,
        color = Dark
    )

    Spacer(Modifier.height(12.dp))

    Text(
        "Belajar memahami seseorang melalui komunikasi, sikap, dan rasa saling menghargai.",
        fontSize = 16.sp,
        color = Dark,
        lineHeight = 24.sp
    )

    Spacer(Modifier.height(24.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Pink, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Column {
            Text("♡", fontSize = 45.sp, color = Color.White)
            Text(
                "Hubungan yang sehat dimulai dari saling mengenal.",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Jadilah diri sendiri dan tetap hargai batasan masing-masing.",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }

    Spacer(Modifier.height(24.dp))

    Text(
        "Yuk, mulai mengenal!",
        fontSize = 21.sp,
        color = Dark,
        fontWeight = FontWeight.Bold
    )

    Spacer(Modifier.height(12.dp))

    MenuCard(
        "♡  Memahami Karakter",
        "Kenali sikap dan cara berkomunikasi.",
        onKarakter
    )

    Spacer(Modifier.height(12.dp))

    MenuCard(
        "✎  Kuis Mengenal Lelaki",
        "Uji pemahamanmu tentang hubungan sehat.",
        onKuis
    )
}

@Composable
fun MenuCard(
    judul: String,
    deskripsi: String,
    aksi: () -> Unit
) {
    Card(
        onClick = aksi,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(Modifier.padding(18.dp)) {
            Text(
                judul,
                color = Dark,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(Modifier.height(6.dp))
            Text(deskripsi, color = Dark, fontSize = 14.sp)
        }
    }
}

@Composable
fun HalamanKarakter() {
    Text(
        "Mengenal Karakter ♡",
        fontSize = 27.sp,
        fontWeight = FontWeight.Bold,
        color = Dark
    )

    Spacer(Modifier.height(12.dp))

    Text(
        "Setiap orang berbeda. Kenali seseorang dari perilakunya secara konsisten, bukan hanya dari kata-katanya.",
        color = Dark,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    Spacer(Modifier.height(20.dp))

    InfoCard(
        "01. Komunikasi",
        "Perhatikan apakah dia mau mendengarkan, berbicara dengan jujur, dan menghargai pendapatmu."
    )

    InfoCard(
        "02. Tanggung jawab",
        "Lihat apakah dia menepati janji dan bersedia bertanggung jawab atas tindakannya."
    )

    InfoCard(
        "03. Rasa hormat",
        "Orang yang menghargaimu akan menghormati keputusan, privasi, dan batasanmu."
    )

    InfoCard(
        "04. Konsistensi",
        "Amati apakah sikapnya baik secara konsisten, bukan hanya ketika menginginkan sesuatu."
    )
}

@Composable
fun InfoCard(judul: String, isi: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = SoftPink
        )
    ) {
        Column(Modifier.padding(18.dp)) {
            Text(
                judul,
                fontSize = 18.sp,
                color = Dark,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(isi, color = Dark, lineHeight = 23.sp)
        }
    }
}

@Composable
fun HalamanKuis() {
    var pilihan by remember { mutableIntStateOf(-1) }
    var diperiksa by remember { mutableStateOf(false) }

    Text(
        "Kuis Mengenal Lelaki ✎",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = Dark
    )

    Spacer(Modifier.height(18.dp))

    Text(
        "Apa tanda seseorang menghargai dirimu?",
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold,
        color = Dark
    )

    Spacer(Modifier.height(12.dp))

    val opsi = listOf(
        "Dia selalu menentukan semua keputusan",
        "Dia menghormati pendapat dan batasanmu",
        "Dia meminta kata sandi semua akunmu",
        "Dia melarangmu berteman dengan orang lain"
    )

    opsi.forEachIndexed { index, jawaban ->
        Card(
            onClick = {
                pilihan = index
                diperiksa = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (pilihan == index)
                    SoftPink else Color.White
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = pilihan == index,
                    onClick = {
                        pilihan = index
                        diperiksa = false
                    }
                )
                Spacer(Modifier.width(8.dp))
                Text(jawaban, color = Dark)
            }
        }
    }

    Spacer(Modifier.height(16.dp))

    Button(
        onClick = { diperiksa = true },
        enabled = pilihan != -1,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Pink
        )
    ) {
        Text("Periksa Jawaban")
    }

    if (diperiksa) {
        Spacer(Modifier.height(12.dp))
        Text(
            if (pilihan == 1)
                "Benar! Hubungan sehat dibangun dengan rasa hormat dan komunikasi."
            else
                "Belum tepat. Jawaban yang benar adalah menghormati pendapat dan batasanmu.",
            color = Dark,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp
        )
    }
}