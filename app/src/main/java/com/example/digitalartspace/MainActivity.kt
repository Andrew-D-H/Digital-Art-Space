package com.example.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalartspace.ui.theme.DigitalArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigitalArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceMain()
                }
            }
        }
    }
}

@Composable
fun ArtWithTitle(ArtPicture: Int, ArtTitle: String, ArtistName: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = ArtPicture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .height(300.dp)
                .width(300.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 4.dp)
                .padding(10.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp)

        ){
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = ArtTitle,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 30.sp
                )
                Text(
                    text = ArtistName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
@Preview
@Composable
fun ArtSpaceMain(){
    var result by remember {
        mutableStateOf(0)
    }
    when (result) {
        1-> ArtWithTitle(
            ArtPicture = R.drawable.mochigushi_,
            ArtTitle = stringResource(R.string.title_1),
            ArtistName = stringResource(id = R.string.artist_1)
        )
       2-> ArtWithTitle(
            ArtPicture = R.drawable.unicha,
            ArtTitle = stringResource(R.string.title_2),
            ArtistName = stringResource(id = R.string.artist_2)
        )
        3-> ArtWithTitle(
            ArtPicture = R.drawable.kyo2,
            ArtTitle = stringResource(R.string.title_3),
            ArtistName = stringResource(id = R.string.artist_3)
        )
        4-> ArtWithTitle(
            ArtPicture = R.drawable.skull_and_zax,
            ArtTitle = stringResource(R.string.title_4),
            ArtistName = stringResource(id = R.string.artist_4)
        )
        else-> ArtWithTitle(
            ArtPicture = R.drawable.mm30212,
            ArtTitle = stringResource(R.string.title_5),
            ArtistName = stringResource(id = R.string.artist_5)
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp)
    ) {
        Button(
            onClick = {
                if (result == 0)
                    result = 4
                else
                    result-- },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
            )
        ) {
            Text(text = "Back")
        }
        Button(
            onClick = {
                if (result == 4)
                    result = 0
                else
                    result++ },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            )
        ) {
            Text(text = "Next")
        }
    }
}



