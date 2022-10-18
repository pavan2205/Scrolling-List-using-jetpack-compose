package com.example.avengers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionScreen(name: String, desc:String, image: String){
    Box(modifier = Modifier.fillMaxSize()) {
        DescriptionSection(description =desc,image=image)
        TopBarSecondScreen(name=name)
    }
}

@Composable
fun TopBarSecondScreen(name:String){
    Row(modifier = Modifier
        .background(Color.Transparent)
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically){
        Text(text = name, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp, color= Color.Cyan)
    }
}

@Composable
fun DescriptionSection(description:String,image:String){
    Box (modifier = Modifier){
        Image(painter = painterResource(id= R.drawable.bg1),
            contentDescription = "", modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Text(
            text = "lol",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3(){
    DescriptionScreen("","","")
}