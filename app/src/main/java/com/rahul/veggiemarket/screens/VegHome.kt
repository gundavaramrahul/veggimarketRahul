package com.rahul.veggiemarket.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rahul.veggiemarket.DetailsPageActivity

import com.rahul.veggiemarket.R
import com.rahul.veggiemarket.UserProfileActivity
import com.rahul.veggiemarket.components.AppToolbar
import com.rahul.veggiemarket.components.NavigationDrawerBody
import com.rahul.veggiemarket.components.NavigationDrawerHeader

import com.rahul.veggiemarket.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 640.dp)
                        .background(color = Color.White)
                ) {



                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 134.dp
                            )
                            .requiredWidth(width = 26.dp)
                            .requiredHeight(height = 38.dp)

                    )
                    {

                        Image(
                            painter = painterResource(id = R.drawable.vlogo),
                            contentDescription = "",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 17.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 157.dp)
                                .requiredHeight(height = 156.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                        )

                    }
                    Text(
                        text = "Fresh Vegetables......",
                        color = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 117.dp,
                                y = 143.dp
                            )
                            .requiredWidth(width = 175.dp)
                            .requiredHeight(height = 29.dp)
                    )
                    val localContext = LocalContext.current



                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 30.dp, y = 450.dp)
                            .requiredWidth(width = 302.dp)
                            .requiredHeight(height = 181.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vv2),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 446.dp
                            )
                            .requiredWidth(width = 457.dp)
                            .requiredHeight(height = 236.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                    )



                    Text(
                        text = "",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .clickable {
                                localContext.startActivity(
                                    Intent(
                                        localContext,
                                        UserProfileActivity::class.java
                                    )
                                )
                            }
                            .offset(
                                x = 58.dp,
                                y = 40.dp
                            ))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 310.dp, y = 26.dp)
                            .requiredSize(size = 42.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(
                                        localContext,
                                        UserProfileActivity::class.java
                                    )
                                )
                            }
                            .clip(shape = CircleShape)
                            .border(
                                border = BorderStroke(0.10000000149011612.dp, Color(0xffbdbdbd)),
                                shape = CircleShape
                            ))


                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 25.dp, y = 200.dp)
                            .requiredWidth(width = 390.dp)
                            .requiredHeight(height = 181.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.vv1),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 21.dp,
                                y = 196.dp
                            )
                            .requiredWidth(width = 457.dp)
                            .requiredHeight(height = 236.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                    )

                    Image(
                        painter = painterResource(id = R.drawable.gpro),
                        contentDescription = " ",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 298.dp,
                                y = 14.dp
                            )
                            .requiredSize(size = 102.dp)
                            .clip(shape = CircleShape)
                            .border(
                                border = BorderStroke(0.10000000149011612.dp, Color(0xffbdbdbd)),
                                shape = CircleShape
                            )
                    )


                }

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}