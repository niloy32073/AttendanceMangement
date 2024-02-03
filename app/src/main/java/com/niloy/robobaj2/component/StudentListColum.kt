package com.niloy.robobaj2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.sqlite.db.SimpleSQLiteQuery
import com.jaikeerthick.composable_graphs.composables.pie.PieChart
import com.jaikeerthick.composable_graphs.composables.pie.model.PieData
import com.niloy.robobaj2.db.StudentInfo
import java.time.LocalDate

@Composable
fun StudentListColumn(student: StudentInfo){
    val date = LocalDate.now().dayOfMonth
    val columName = "d$date"
    val present:Float = ((student.present * 100.0)/date).toFloat()
    val absent:Float = (((date-student.present) * 100.0)/date).toFloat()
    val pieChartData = listOf(
        PieData(value = present, label = "উপস্থিত", color = Color.Green),
        PieData(value = absent, label = "অনুপস্থিত", color = Color.Red)
    )

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
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            PieChart(data =pieChartData, modifier = Modifier.size(60.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .border(
                        1.dp, Color.Gray,
                        RoundedCornerShape(2.dp)
                    )
                    .padding(2.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(
                                width = 10.dp,
                                height = 10.dp
                            ) // Set size based on desired diameter
                            .clip(shape = CircleShape) // Clip to circular shape
                            .background(color = Color.Green) // Set desired color
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "ঊপস্থিত ${(student.present * 100)/date}%", fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .border(
                        1.dp, Color.Gray,
                        RoundedCornerShape(2.dp)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .size(
                                width = 10.dp,
                                height = 10.dp
                            ) // Set size based on desired diameter
                            .clip(shape = CircleShape) // Clip to circular shape
                            .background(color = Color.Red) // Set desired color
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "অনুপস্থিত ${((date-student.present) * 100)/date}%", fontSize = 15.sp)
                }

            }
        }

    }
}