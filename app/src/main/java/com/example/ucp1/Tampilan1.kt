package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Tampilan(modifier: Modifier = Modifier) {
    Column() {
        BagianAtas()
        isinya()
    }
}

@Composable
fun BagianAtas() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0e91f3))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )


                Spacer(modifier = Modifier.height(8.dp))


                Column {
                    Text(
                        text = "Halo,",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Muhammad Ikhsan",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }


            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
        }
    }
}




@Composable
fun isinya() {
    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var datanoHp by remember { mutableStateOf("") }
    var dataJenisk by remember { mutableStateOf("") }

    val dataJK = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = "Yuk lengkapin data dirimu!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama Anda!") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icon orang"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = noHp,
            onValueChange = { noHp = it },
            label = { Text("Nomor Handphone") },
            placeholder = { Text("Masukkan Nomor Handphone Anda!") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Icon Telepon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            text = "Jenis Kelamin",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row {
            dataJK.forEach { selectedJK ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = jenisK == selectedJK,
                        onClick = { jenisK = selectedJK }
                    )
                    Text(text = selectedJK)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                dataNama = nama
                datanoHp = noHp
                dataJenisk = jenisK
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0e91f3)
            )
        ) {
            Text("Simpan", color = Color.White)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color(0xFF0e91f3))
            ) {
                TampilData(judul = "Nomor Handphone", isinya = datanoHp, icon = Icons.Default.Phone)
                TampilData(judul = "Jenis Kelamin", isinya = dataJenisk, icon = Icons.Default.Person)
            }
        }
    }
}

@Composable
fun TampilData(judul: String, isinya: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        Icon(
            imageVector = icon,
            contentDescription = "Icon $judul",
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(judul, fontWeight = FontWeight.Bold)
        Text(": $isinya", modifier = Modifier.weight(2f))
    }
}
