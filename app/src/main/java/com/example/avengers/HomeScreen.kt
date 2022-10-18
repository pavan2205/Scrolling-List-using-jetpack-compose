package com.example.avengers

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

data class Avengers(
    val img1:Int,
    val img2:Int,
    val name:String,
    val description:String
)


val avengersDetails= listOf(
    Avengers(R.drawable.ironman1,R.drawable.ironman2,"Iron Man","The Hulk is a superhero appearing in American comic books published by Marvel Comics. " +
            "Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the" +
            " debut issue of The Incredible Hulk (May 1962). In his comic book appearances," +
            " the character, who has dissociative identity disorder (DID), is primarily represented" +
            " by the alter ego Hulk, a green-skinned, hulking and muscular humanoid possessing a " +
            "limitless degree of physical strength, and the alter ego Dr. Robert Bruce Banner, a " +
            "physically weak, socially withdrawn, and emotionally reserved physicist, both of whom " +
            "typically resent each other."),
    Avengers(R.drawable.captainamerica1,R.drawable.captainamerica2,"Captain America","The Hulk is a superhero appearing in American comic books published by Marvel Comics. " +
            "Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the" +
            " debut issue of The Incredible Hulk (May 1962). In his comic book appearances," +
            " the character, who has dissociative identity disorder (DID), is primarily represented" +
            " by the alter ego Hulk, a green-skinned, hulking and muscular humanoid possessing a " +
            "limitless degree of physical strength, and the alter ego Dr. Robert Bruce Banner, a " +
            "physically weak, socially withdrawn, and emotionally reserved physicist, both of whom " +
            "typically resent each other."),
    Avengers(R.drawable.spiderman1,R.drawable.spiderman2,"Spider Man","The Hulk is a superhero appearing in American comic books published by Marvel Comics. " +
            "Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the" +
            " debut issue of The Incredible Hulk (May 1962). In his comic book appearances," +
            " the character, who has dissociative identity disorder (DID), is primarily represented" +
            " by the alter ego Hulk, a green-skinned, hulking and muscular humanoid possessing a " +
            "limitless degree of physical strength, and the alter ego Dr. Robert Bruce Banner, a " +
            "physically weak, socially withdrawn, and emotionally reserved physicist, both of whom " +
            "typically resent each other."),
    Avengers(R.drawable.thor2,R.drawable.thor1,"Thor","The Hulk is a superhero appearing in American comic books published by Marvel Comics. " +
            "Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the" +
            " debut issue of The Incredible Hulk (May 1962). In his comic book appearances," +
            " the character, who has dissociative identity disorder (DID), is primarily represented" +
            " by the alter ego Hulk, a green-skinned, hulking and muscular humanoid possessing a " +
            "limitless degree of physical strength, and the alter ego Dr. Robert Bruce Banner, a " +
            "physically weak, socially withdrawn, and emotionally reserved physicist, both of whom " +
            "typically resent each other."),
    Avengers(R.drawable.hulk1,R.drawable.hulk2,"Hulk","The Hulk is a superhero appearing in American comic books published by Marvel Comics. " +
            "Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the" +
            " debut issue of The Incredible Hulk (May 1962). In his comic book appearances," +
            " the character, who has dissociative identity disorder (DID), is primarily represented" +
            " by the alter ego Hulk, a green-skinned, hulking and muscular humanoid possessing a " +
            "limitless degree of physical strength, and the alter ego Dr. Robert Bruce Banner, a " +
            "physically weak, socially withdrawn, and emotionally reserved physicist, both of whom " +
            "typically resent each other.")
)

@Composable
fun HomeScreen(modifier: Modifier,navController:NavController){
    Column() {
        TopBar()
        ListOfCards(listOfAvengers = avengersDetails,navController=navController)
    }
}

@Composable
fun TopBar(){
    Row(modifier = Modifier
        .background(Color.Cyan)
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo", modifier = Modifier
                .size(64.dp)
                .fillMaxWidth())
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Avengers", fontWeight = FontWeight.Bold, fontSize = 25.sp, color= Color.Black, letterSpacing = 1.5.sp)
    }
}
@Composable
fun ListOfCards(listOfAvengers:List<Avengers>,navController: NavController){
    LazyColumn(contentPadding = PaddingValues(15.dp), verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxSize()
        .paint(painter = painterResource(id = R.drawable.bg1), contentScale = ContentScale.Crop)){
        items(listOfAvengers){avenger->
            AvengerDetailsCard(image = avenger.img1,image2=avenger.img2, name =avenger.name , desc = avenger.description,navController=navController)
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
fun AvengerDetailsCard(image:Int,image2:Int,name:String,desc:String,navController: NavController){
    Card(modifier = Modifier
        .clip(RoundedCornerShape(15.dp))
        .clickable {
          navController.navigate(route="description_screen")
        },
        elevation = 5.dp){
        Column(modifier = Modifier
            .paint(painter = painterResource(id = R.drawable.bg2), contentScale = ContentScale.Crop)
            .fillMaxWidth()
            .padding(10.dp)) {
            Image(painter = painterResource(id = image), contentDescription = name, modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp,color=Color.Cyan,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .background(Color.Gray)
                    .padding(5.dp), textAlign = TextAlign.Center)
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultReview(){
    HomeScreen(modifier = Modifier, navController = rememberNavController())
}