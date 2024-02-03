package com.niloy.robobaj2.screens.seestudentlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.niloy.robobaj2.component.DropdownMenuWithLabel
import com.niloy.robobaj2.component.StudentAttendanceColumn
import com.niloy.robobaj2.component.StudentListColumn

@Composable
fun SeeStudent(navHostController: NavHostController,viewModel: SeeStudentListViewModel){
    val students by viewModel.students.observeAsState(emptyList())
    var className by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        DropdownMenuWithLabel(label = "ক্লাস", itemList = listOf("প্রথম শ্রেণি","দ্বিতীয় শ্রেণি","তৃতীয় শ্রেণি","চতুর্থ শ্রেণি","পঞ্চম শ্রেণি"), onSelectedValueChange = {value->className = value
            viewModel.setClassName(value)
        })
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "শিক্ষার্থী তালিকা")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth(.9f)){
            items(students){ student ->
                StudentListColumn(student = student)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}