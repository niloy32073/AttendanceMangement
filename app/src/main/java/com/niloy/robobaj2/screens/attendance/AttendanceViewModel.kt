package com.niloy.robobaj2.screens.attendance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.sqlite.db.SupportSQLiteQuery
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.db.StudentInfo
import kotlinx.coroutines.launch

class AttendanceViewModel(private  val repository: Repository):ViewModel() {
    private var className: String = ""
    private val _students = MutableLiveData<List<StudentInfo>>()
    val students: LiveData<List<StudentInfo>> = _students

    init {
        viewModelScope.launch {
            _students.value = repository.getAllStudentShort(className)
        }
    }

    fun giveAttendance(query: SupportSQLiteQuery) {
        viewModelScope.launch {
            repository.updateAttendance(query)
        }
    }

    fun setClassName(newClassName: String) {
        className = newClassName
        viewModelScope.launch {
            _students.value = repository.getAllStudentShort(newClassName)
        }
    }
}