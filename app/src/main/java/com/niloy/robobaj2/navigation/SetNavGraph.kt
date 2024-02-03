package com.niloy.robobaj2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.screens.MainScreen
import com.niloy.robobaj2.screens.addstudent.AddStudent
import com.niloy.robobaj2.screens.addstudent.AddStudentViewModel
import com.niloy.robobaj2.screens.attendance.Attendance
import com.niloy.robobaj2.screens.attendance.AttendanceViewModel
import com.niloy.robobaj2.screens.seestudentlist.SeeStudent
import com.niloy.robobaj2.screens.seestudentlist.SeeStudentListViewModel
import com.niloy.robobaj2.screens.studentlist.StudentList
import com.niloy.robobaj2.screens.studentlist.StudentListViewModel

@Composable
fun SetNavGraph(navHostController: NavHostController, startDestination:String,repository: Repository) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(NavItem.Main.route) {
            MainScreen(navController = navHostController, repository)
        }
        composable(NavItem.AddStudent.route) {
            AddStudent(
                navController = navHostController,
                viewModel = AddStudentViewModel(repository = repository)
            )
        }
        composable(NavItem.Attendance.route) {
            Attendance(
                navHostController = navHostController,
                viewModel = AttendanceViewModel(repository = repository)
            )
        }
        composable(NavItem.SeeStudent.route) {
            SeeStudent(
                navHostController = navHostController,
                viewModel = SeeStudentListViewModel(repository = repository)
            )
        }
        composable(NavItem.StudentList.route) {
            StudentList(navHostController = navHostController, viewModel = StudentListViewModel(repository=repository))
        }
    }
}