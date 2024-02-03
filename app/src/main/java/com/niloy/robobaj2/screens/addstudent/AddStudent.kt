package com.niloy.robobaj2.screens.addstudent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.niloy.robobaj2.R
import com.niloy.robobaj2.component.CustomEditText
import com.niloy.robobaj2.component.DropdownMenuWithLabel
import com.niloy.robobaj2.db.Student

@Composable
fun AddStudent(navController: NavHostController,viewModel: AddStudentViewModel){
    var name by remember {
        mutableStateOf("")
    }

    var className by remember {
        mutableStateOf("")
    }

    var roll by remember {
        mutableStateOf(0)
    }

    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.user), contentDescription = "User", modifier = Modifier.height(150.dp).width(150.dp))
        Spacer(modifier = Modifier.height(10.dp))
        CustomEditText(label = "নাম", placeholder = "শিক্ষার্থীর নাম", inputType = "text" , modifier = Modifier.fillMaxWidth(.9f), onValueChanged = {value-> name = value})
        Spacer(modifier = Modifier.height(10.dp))
        CustomEditText(label = "রোল", placeholder = "শিক্ষার্থীর রোল", inputType = "int" , modifier = Modifier.fillMaxWidth(.9f), onValueChanged = {value-> roll = value.toInt()})
        Spacer(modifier = Modifier.height(10.dp))
        DropdownMenuWithLabel(label = "ক্লাস", itemList = listOf("প্রথম শ্রেণি","দ্বিতীয় শ্রেণি","তৃতীয় শ্রেণি","চতুর্থ শ্রেণি","পঞ্চম শ্রেণি"), onSelectedValueChange = {value->className = value})
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                if (className.isNotEmpty()  &&name.isNotEmpty()) {
                    viewModel.addStudent(Student(roll = roll, name = name, className = className))
                }
            },
            modifier = Modifier
                .fillMaxWidth(.9f),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "শিক্ষার্থী যোগ করুন")
        }
    }
}