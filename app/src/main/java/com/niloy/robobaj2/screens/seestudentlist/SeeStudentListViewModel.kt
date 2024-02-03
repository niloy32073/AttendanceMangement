package com.niloy.robobaj2.screens.seestudentlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.db.Student
import com.niloy.robobaj2.db.StudentInfo
import kotlinx.coroutines.launch

class SeeStudentListViewModel(private val repository: Repository):ViewModel() {
    private var className: String = ""
    private val _students = MutableLiveData<List<StudentInfo>>()
    val students: LiveData<List<StudentInfo>> = _students

    init {
        viewModelScope.launch {
            _students.value = repository.getAllStudentShort(className)  // Fetch initial data
        }
    }

    fun setClassName(newClassName: String) {
        className = newClassName
        viewModelScope.launch {
            _students.value = repository.getAllStudentShort(newClassName)  // Refetch data when class name changes
        }
    }
}