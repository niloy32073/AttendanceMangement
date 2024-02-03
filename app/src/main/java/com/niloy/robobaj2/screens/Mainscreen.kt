package com.niloy.robobaj2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.niloy.robobaj2.Model.ScreenList
import com.niloy.robobaj2.R
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.navigation.NavItem

@Composable
fun MainScreen(navController:NavHostController,repository: Repository){
    var Screens = listOf<ScreenList>(
        ScreenList("হাজিরা দিন",NavItem.Attendance.route, R.drawable.checklist),
        ScreenList("হাজিরা দেখুন",NavItem.StudentList.route, R.drawable.document),
        ScreenList("শিক্ষার্থী যোগ করুন",NavItem.AddStudent.route, R.drawable.adduser),
        ScreenList("শিক্ষার্থী তালিকা",NavItem.SeeStudent.route, R.drawable.shortlist)
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)){
            items(Screens){Screen->
                Card (modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
                    .clickable {
                        navController.navigate(Screen.route)
                    }){
                    Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally){
                        Image(painter = painterResource(id = Screen.id), contentDescription = Screen.tittle, modifier = Modifier
                            .height(98.dp)
                            .width(98.dp))
                        Text(text = Screen.tittle)
                    }
                }
            }
        }
    }
}