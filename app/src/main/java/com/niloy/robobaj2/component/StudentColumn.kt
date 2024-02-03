package com.niloy.robobaj2.component

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.sqlite.db.SimpleSQLiteQuery
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.db.StudentDb
import com.niloy.robobaj2.db.StudentInfo
import com.niloy.robobaj2.screens.attendance.AttendanceViewModel
import java.time.LocalDate


@Composable
fun StudentColumn(student:StudentInfo,viewModel: AttendanceViewModel){
    val date = LocalDate.now().dayOfMonth
    val columName = "d$date"
    val query = SimpleSQLiteQuery("UPDATE student_table SET $columName = ? , present = ? WHERE id = ?",
        arrayOf(true,student.present+1,student.id))
    val query2 = SimpleSQLiteQuery("UPDATE student_table SET $columName = ? , present = ? WHERE id = ?",
        arrayOf(false,student.present-1,student.id))
    var selected by remember {
        mutableStateOf("r")
    }
    Row (modifier = Modifier
        .fillMaxWidth()
        .shadow(2.dp, shape = RoundedCornerShape(5.dp))
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Column {
            Text(text = "নাম : ${student.name}", fontSize = 20.sp)
            Text(text = "রোল : ${student.roll}", fontSize = 10.sp)
            Text(text = "শ্রেণি : ${student.className}", fontSize = 10.sp)
            Text(text = "ঊপস্থিত : ${student.present}", fontSize = 10.sp)
        }
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .border(
                    1.dp, Color.Gray,
                    RoundedCornerShape(2.dp)
                )
                .padding(2.dp)
                .background(if (selected =="g") Color.Gray else Color.Transparent)
                .clickable {
                    selected = "g"
                    viewModel.giveAttendance(query)
                }) {
                Box(
                    modifier = Modifier
                        .size(width = 10.dp, height = 10.dp) // Set size based on desired diameter
                        .clip(shape = CircleShape) // Clip to circular shape
                        .background(color = Color.Green) // Set desired color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "ঊপস্থিত", fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .border(
                    1.dp, Color.Gray,
                    RoundedCornerShape(2.dp)
                )
                .padding(2.dp).background(if (selected =="r") Color.Gray else Color.Transparent).clickable {
                    selected = "r"
                    viewModel.giveAttendance(query2)
                }) {
                Box(
                    modifier = Modifier
                        .size(width = 10.dp, height = 10.dp) // Set size based on desired diameter
                        .clip(shape = CircleShape) // Clip to circular shape
                        .background(color = Color.Red) // Set desired color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "অনুপস্থিত", fontSize = 15.sp)
            }

        }
    }
}