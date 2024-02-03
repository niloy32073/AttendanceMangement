package com.niloy.robobaj2.screens.studentlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.db.Student
import kotlinx.coroutines.launch

class StudentListViewModel(private  val repository: Repository):ViewModel() {
    private var className: String = ""
    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> = _students

    init {
        viewModelScope.launch {
            _students.value = repository.getAllStudent(className)
        }
    }

    fun setClassName(newClassName: String) {
        className = newClassName
        viewModelScope.launch {
            _students.value = repository.getAllStudent(newClassName)
        }
    }
}