package com.sharleen.sokohub.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.clementvexegon.sokohub.R
import com.clementvexegon.sokohub.ui.theme.Blueberry
import com.sharleen.sokohub.navigation.ROUT_ONBOARDING
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){
    val coroutinescope = rememberCoroutineScope ()
    coroutinescope.launch {
        delay(3000)
        navController.navigate(ROUT_ONBOARDING)

    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blueberry),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {Image(
        painter = painterResource(R.drawable.img),
        contentDescription = "img",
        modifier = Modifier.size(200.dp)
    )



    }






}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}