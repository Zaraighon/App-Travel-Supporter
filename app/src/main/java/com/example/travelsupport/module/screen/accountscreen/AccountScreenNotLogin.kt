package com.example.travelsupport.module.screen.accountscreen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.travelsupport.R
import com.example.travelsupport.module.screen.navigation.BottomBarScaffold
import com.example.travelsupport.ui.theme.H1Bold
import com.example.travelsupport.ui.theme.TitleLight2
import com.example.travelsupport.ui.theme.TitleSemiBold2


//fun AccountScreenNotLogin(navHostController: NavHostController, state: SignInState, onSignInClick:()->Unit)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreenNotLogin(navHostController: NavHostController) {
    Scaffold (
        bottomBar = {
            BottomBarScaffold(navHostController)
        }
    ){
        paddingValues ->

            Box(modifier = Modifier.fillMaxSize()
                .padding(paddingValues)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(1f)) {
                            Text(text = "Tài khoản",
                                style = H1Bold,
                                modifier = Modifier
                                    .padding(20.dp,20.dp,0.dp,0.dp),)
                            Image(painter = painterResource(id = R.drawable.userimg),
                                contentDescription = "User image",
                                Modifier
                                    .padding(top = 20.dp, start = 130.dp)
                                    .size(60.dp))
                        }
                        Image(painter = painterResource(id = R.drawable.bluebgacc),
                            contentDescription = "Banner background",
                            modifier = Modifier
                                .zIndex(0f)
                                .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)),
                            contentScale = ContentScale.Crop)
                    }
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp))
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Transparent),
                        contentAlignment = Alignment.Center) {
                        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                            Text(text = "Đăng nhập để dễ dàng lưu trữ và khám phá cho những kỳ nghỉ sắp tới",
                                style = TitleLight2)
                            Button(onClick = {}, modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 30.dp)
                                .shadow(10.dp, RoundedCornerShape(20.dp)),
                                colors = ButtonDefaults.buttonColors(Color.Black)) {
                                Text(text = "Đăng nhập", style = TitleSemiBold2)
                            }
                        }
                    }
                }
            }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AccountPreview(){
//    AccountScreenNotLogin()
}