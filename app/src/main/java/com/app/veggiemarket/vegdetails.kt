package com.app.veggiemarket

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.veggiemarket.ui.theme.VeggiemarketTheme

class DetailsPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeggiemarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width =410.dp)
            .requiredHeight(height = 940.dp)
            .background(color = Color(0x4B4CAF50))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-1).dp,
                    y = (-86).dp)
                .requiredWidth(width = 415.dp)
                .requiredHeight(height = 512.dp)
                .background(color = Color(0x4B4CAF50))
        ) {





//            Image(
//                painter = painterResource(id = R.drawable.vege1),
//                contentDescription = "",
//                modifier = Modifier
//                    .align(alignment = Alignment.TopStart)
//                    .offset(x = 20.dp,
//                        y = 88.dp)
//                    .requiredWidth(width = 375.dp)
//                    .requiredHeight(height = 463.dp))



            Text(
                text = "£ 40.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 281.dp,
                        y = 707.dp))
            Text(
                text = "Potato",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 567.dp))
            //here


            val localContext = LocalContext.current
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 70.dp,
                        y = 838.dp)
                    .requiredWidth(width = 285.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xFF4CAF50))
                    .clickable {
                        localContext.startActivity(
                            Intent(localContext, AddtoCartActivity::class.java)
                        )
                    }
            )
            Text(
                text = "Add to Cart",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 181.dp,
                        y = 853.dp))
            Text(
                text = "No.of kgs to buy",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 18.dp,
                        y = 707.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VeggiemarketTheme {
        Greeting("Android")
    }
}