package com.niloy.robobaj2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(student: Student)

    @Query("SELECT * FROM student_table WHERE className = :className")
    suspend fun getAllRecords(className: String): List<Student>
    @Query("SELECT id, roll, name,className,present FROM student_table WHERE className = :className")
    suspend fun getAllStudentRollNamesByClass(className: String): List<StudentInfo>

    @RawQuery
    suspend fun updateAttendanceRecordRaw(query: SupportSQLiteQuery):Long

    @Query("SELECT * FROM student_table WHERE id = :id")
    suspend fun getStudentDetails(id: Int): Student
}