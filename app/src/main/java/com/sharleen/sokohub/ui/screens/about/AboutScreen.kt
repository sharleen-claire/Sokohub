package com.clementvexegon.sokohub.ui.screens.about

import android.R.attr.shape
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.clementvexegon.sokohub.ui.theme.Blueberry
import com.sharleen.sokohub.navigation.ROUT_ABOUT
import com.sharleen.sokohub.navigation.ROUT_HOME
import com.sharleen.sokohub.navigation.ROUT_INTENT
import com.sharleen.sokohub.navigation.ROUT_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController){

    val mContext = LocalContext.current

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(


        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Contact Screen") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                    IconButton(onClick = {navController.navigate(ROUT_ABOUT)}) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Blueberry,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )



        },



        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Blueberry
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_INTENT)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_LOGIN)
                    }
                )



            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Blueberry
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {


                //Main Contents of the page
                // BLUE CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("John Smith", color = Color.White)
                        Text("Business Consultant", color = Color.White)

                        Spacer(modifier = Modifier.height(20.dp))
                        Row {
                            Icon(Icons.Default.Call, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))

                            OutlinedButton(
                                onClick = {

                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0700839987".toUri()
                                    mContext.startActivity(callIntent)

                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("+1 234 3255 3654", color = Color.White)
                            }

                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Row {
                            Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))

                            OutlinedButton(
                                onClick = {

                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("clairesharleen17@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("johnsmith@gmail.com", color = Color.White)
                            }




                        }
                    }
                }


                // RED CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE53935))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("Amanda Black", color = Color.White)
                        Text("Dentist", color = Color.White)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row {
                            Icon(Icons.Default.Call, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))

                            OutlinedButton(
                                onClick = {

                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0700839987".toUri()
                                    mContext.startActivity(callIntent)

                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("+1 356 3255 3654", color = Color.White)

                            }


                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Row {
                            Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            OutlinedButton(
                                onClick = {

                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("clairesharleen17@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("amandablack@gmail.com", color = Color.White)
                            }


                        }
                    }
                }


                // ORANGE CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF9A825))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("David Hill", color = Color.White)
                        Text("Designer", color = Color.White)

                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            Icon(Icons.Default.Call, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))


                            OutlinedButton(
                                onClick = {

                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0700839987".toUri()
                                    mContext.startActivity(callIntent)

                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("+1 789 3255 3654", color = Color.White)
                            }

                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Row {
                            Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))

                            OutlinedButton(
                                onClick = {

                                    val shareIntent = Intent(Intent.ACTION_SEND)
                                    shareIntent.type = "text/plain"
                                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("clairesharleen17@gmail.com"))
                                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                                    mContext.startActivity(shareIntent)
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth().padding(20.dp, end =20.dp )

                            ) {
                                Text("davidhill@gmail.com", color = Color.White)
                            }


                        }
                    }
                }
            }






















        }
    )

    //End of scaffold









}




@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}
