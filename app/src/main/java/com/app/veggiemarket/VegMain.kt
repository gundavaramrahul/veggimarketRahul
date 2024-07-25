 Text(
                text = "£ 126.00",
                color = Color(0xFF4CAF50),
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 30.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 241.dp,
                        y = 671.dp))
            Text(
                text = "£ 6.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 295.dp,
                        y = 621.dp))
            Text(
                text = "£ 120.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 280.dp,
                        y = 581.dp))
            Text(
                text = "vegetables",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 114.dp,
                        y = 34.dp))
            var sliderPosition by remember { mutableStateOf(0f) }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                onValueChangeFinished = { },
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 316.dp,
                        y = 27.dp)
                    .requiredSize(size = 32.dp))
            Text(
                text = "vegetables Amount Total",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 681.dp))
            Text(
                text = "Delivery charges",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 625.dp))
            Text(
                text = "Sub Total",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 585.dp))



            val context = LocalContext.current
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 67.dp,
                        y = 738.dp)
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 50.dp)
                    .clickable {
                        context.startActivity(
                            Intent(context, PaymentActivity::class.java))
                    }

                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xFF4CAF50)))
            Text(
                text = "Go To Payment page",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 148.dp,
                        y = 753.dp))
            Image(
                painter = painterResource(id = R.drawable.ff1),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = -10.dp,
                        y = 249.dp)
                    .requiredWidth(width = 502.dp)
                    .requiredHeight(height = 155.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))
            Image(
                painter = painterResource(id = R.drawable.ff22),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = -10.dp,
                        y = 94.dp)
                    .requiredWidth(width =500.dp)
                    .requiredHeight(height = 154.dp)
                    .clip(shape = RoundedCornerShape(24.dp)))









///86


































 Text(

                text = "£ 40.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 294.dp,
                        y = 270.dp))
            Text(

                text = "£ 40.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 294.dp,
                        y = 430.dp))
            Text(
                text = "£ 40.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 294.dp,
                        y = 116.dp))





///106