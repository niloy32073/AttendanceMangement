package com.niloy.robobaj2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niloy.robobaj2.db.Student
import java.time.LocalDate

@Composable
fun StudentAttendanceColumn(student: Student){
    val date:Int = LocalDate.now().dayOfMonth
    Row(modifier = Modifier.fillMaxWidth(.9f), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "${student.roll.toString()} ${student.name}", modifier = Modifier.width(100.dp))
        LazyRow(){
            repeat(date) { count ->
                item {
                    Box(
                        modifier = Modifier
                            .size(20.dp, 20.dp)
                            .padding(2.dp)
                            .background(
                                if (student.javaClass
                                        .getDeclaredField("d${count + 1}")
                                        .apply {
                                            isAccessible = true
                                        }.getBoolean(student)
                                ) Color.Green else Color.Red
                            ),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "${count + 1}", fontSize = 10.sp, fontWeight = FontWeight(800), color = Color.White)
                    }
                }
            }

        }
    }
}