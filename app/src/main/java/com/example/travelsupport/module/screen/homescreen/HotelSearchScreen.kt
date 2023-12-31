package com.example.travelsupport.module.screen.homescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.travelsupport.R
import com.example.travelsupport.module.button.GrayButton
import com.example.travelsupport.module.screen.CircularIndeterminateProgressBar
import com.example.travelsupport.module.screen.homescreen.locationmodel.LocationViewModel
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel
import com.example.travelsupport.ui.theme.Kanit_Bold
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.LightBlue
import com.example.travelsupport.ui.theme.navigationItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelSearchScreen(navHostController: NavHostController,locationViewModel: LocationViewModel) {
    var address by remember { mutableStateOf("") }
    val loading= locationViewModel.loading.value

    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black, // Màu chữ
        cursorColor = Color.Blue, // Màu dấu nháy
        focusedBorderColor = Color.Blue, // Màu viền khi được focus
        unfocusedBorderColor = Color.Black, // Màu viền khi không được focus
        disabledTextColor = Color.Gray // Màu chữ khi TextField bị tắt
    )
    Column(
        modifier = Modifier
            .background(LightBlue)
            .fillMaxSize()
    ) {
        Text(text = "Khách sạn",
            modifier = Modifier
                .padding(10.dp,20.dp,0.dp,0.dp),
            fontSize = 25.sp,
            fontFamily = Kanit_Bold,
            lineHeight = 30.sp)
            OutlinedTextField(
                value = address,
                onValueChange = { value -> address = value },
                label = { Text("Bạn sắp đến đâu", style = navigationItem) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = textFieldColors

            )

        Spacer(modifier = Modifier.height(16.dp))

        GrayButton(text = "Tìm",
            textColor = Color.Black,
            icon = {
                Image(painter = painterResource(id = R.drawable.search), contentDescription = null, Modifier.size(30.dp)) },
            fontFamily = Kanit_Light,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onclick = {locationViewModel.searchLocations("7904AD3CB20F4523B18C73F170779ED9", address+" hotel",address, "en")}
        )

        Spacer(modifier = Modifier.height(16.dp))

//        locationViewModel.locations.value?.let { locations ->
//            LocationList(locations, navHostController)
//        }
        Box (modifier = Modifier.fillMaxSize()){
            locationViewModel.locations.value?.let { locations ->
                LocationList(locations,navHostController)
            }
            CircularIndeterminateProgressBar(isDisplayed = loading, modifier = Modifier.fillMaxSize().padding(top = 20.dp))

        }
    }
    Log.d("SearchScreen", "HotelSearchScreen")
}