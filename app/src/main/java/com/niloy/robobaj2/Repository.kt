package com.niloy.robobaj2

import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.niloy.robobaj2.db.Student
import com.niloy.robobaj2.db.StudentDb
import com.niloy.robobaj2.db.StudentInfo

class Repository(private val db:StudentDb) {
    suspend fun insertStudent(student: Student) = db.studentDao().insert(student)
    suspend fun getAllStudent(className:String):List<Student> = db.studentDao().getAllRecords(className)
    suspend fun getAllStudentShort(className: String):List<StudentInfo> = db.studentDao().getAllStudentRollNamesByClass(className)
    suspend fun getStudentDetailInfo(id:Int):Student = db.studentDao().getStudentDetails(id)
    suspend fun updateAttendance(query: SupportSQLiteQuery) = db.studentDao().updateAttendanceRecordRaw(query)
}