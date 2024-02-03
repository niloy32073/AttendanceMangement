package com.niloy.robobaj2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val roll: Int,
    val name: String,
    val className: String,
    @ColumnInfo(name = "d1") var d1: Boolean = false,
    @ColumnInfo(name = "d2") var d2: Boolean = false,
    @ColumnInfo(name = "d3") var d3: Boolean = false,
    @ColumnInfo(name = "d4") var d4: Boolean = false,
    @ColumnInfo(name = "d5") var d5: Boolean = false,
    @ColumnInfo(name = "d6") var d6: Boolean = false,
    @ColumnInfo(name = "d7") var d7: Boolean = false,
    @ColumnInfo(name = "d8") var d8: Boolean = false,
    @ColumnInfo(name = "d9") var d9: Boolean = false,
    @ColumnInfo(name = "d10") var d10: Boolean = false,
    @ColumnInfo(name = "d11") var d11: Boolean = false,
    @ColumnInfo(name = "d12") var d12: Boolean = false,
    @ColumnInfo(name = "d13") var d13: Boolean = false,
    @ColumnInfo(name = "d14") var d14: Boolean = false,
    @ColumnInfo(name = "d15") var d15: Boolean = false,
    @ColumnInfo(name = "d16") var d16: Boolean = false,
    @ColumnInfo(name = "d17") var d17: Boolean = false,
    @ColumnInfo(name = "d18") var d18: Boolean = false,
    @ColumnInfo(name = "d19") var d19: Boolean = false,
    @ColumnInfo(name = "d20") var d20: Boolean = false,
    @ColumnInfo(name = "d21") var d21: Boolean = false,
    @ColumnInfo(name = "d22") var d22: Boolean = false,
    @ColumnInfo(name = "d23") var d23: Boolean = false,
    @ColumnInfo(name = "d24") var d24: Boolean = false,
    @ColumnInfo(name = "d25") var d25: Boolean = false,
    @ColumnInfo(name = "d26") var d26: Boolean = false,
    @ColumnInfo(name = "d27") var d27: Boolean = false,
    @ColumnInfo(name = "d28") var d28: Boolean = false,
    @ColumnInfo(name = "d29") var d29: Boolean = false,
    @ColumnInfo(name = "d30") var d30: Boolean = false,
    @ColumnInfo(name = "d31") var d31: Boolean = false,
    @ColumnInfo(name = "present") var present: Int = 0
)
