package com.niloy.robobaj2.navigation

sealed class NavItem(val route:String) {
    object Main:NavItem("main")
    object AddStudent:NavItem("addStudent")
    object Attendance:NavItem("attendance")
    object SeeStudent:NavItem("seeStudent")
    object StudentList:NavItem("studentList")
}