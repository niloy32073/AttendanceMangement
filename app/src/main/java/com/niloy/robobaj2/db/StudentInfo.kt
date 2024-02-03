package com.niloy.robobaj2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

data class StudentInfo(val id:Int,val roll:Int,val name:String,val className : String,val present:Int)
