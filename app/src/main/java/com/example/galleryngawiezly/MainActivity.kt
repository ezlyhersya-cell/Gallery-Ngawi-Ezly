package com.example.galleryngawiezly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

data class Wisata(
    val name: String,
    val description: String,
    val image: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryNgawi()
        }
    }
}

@Composable
fun GalleryNgawi() {

    val wisataList = listOf(

        Wisata(
            "Benteng Pendem Ngawi",
            "Benteng Pendem Ngawi (nama resminya Benteng Van den Bosch) adalah bangunan peninggalan kolonial Belanda yang terletak di Kelurahan Pelem, Kecamatan Ngawi Kota, Kabupaten Ngawi, Jawa Timur",
            R.drawable.wisata_ngawi_1
        ),

        Wisata(
            "Taman Candi Ngawi",
            "Tempat wisata untuk menawarkan suasana taman untuk bersantai dan menikmati keindahan alam.",
            R.drawable.wisata_ngawi_2
        ),

        Wisata(
            "Kebun Teh Jamus Ngawi",
            "Wisata alam dengan pemandangan perkebunan teh yang hijau dan udara yang sejuk.",
            R.drawable.wisata_ngawi_3
        ),

        Wisata(
            "Sumber Koso Ngawi",
            "Sumber Koso adalah destinasi wisata alam berupa sumber mata air alami yang terletak di lereng Gunung Lawu, tepatnya di Desa Girikerto, Kecamatan Sine, Kabupaten Ngawi, Jawa Timur (tidak jauh dari Kebun Teh Jamus).",
            R.drawable.wisata_ngawi_4
        ),

        Wisata(
            "Srambang Park Ngawi",
            "Destinasi wisata alam dengan sumber air yang memberikan suasana segar dan asri.",
            R.drawable.wisata_ngawi_5
        )
    )

    var currentIndex by remember {
        mutableIntStateOf(0)
    }

    val currentWisata = wisataList[currentIndex]

    MaterialTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Gallery Ngawi Ezly",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(25.dp))

                Image(
                    painter = painterResource(
                        id = currentWisata.image
                    ),

                    contentDescription = currentWisata.name,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),

                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = currentWisata.name,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = currentWisata.description,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "${currentIndex + 1} / ${wisataList.size}",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = {
                            currentIndex--
                        },
                        enabled = currentIndex > 0
                    ) {
                        Text("Previous")
                    }

                    Button(
                        onClick = {
                            currentIndex++
                        },
                        enabled = currentIndex < wisataList.size - 1
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GalleryNgawiPreview() {
    GalleryNgawi()
}