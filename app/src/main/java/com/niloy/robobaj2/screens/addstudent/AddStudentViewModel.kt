package com.niloy.robobaj2.screens.addstudent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niloy.robobaj2.Repository
import com.niloy.robobaj2.db.Student
import kotlinx.coroutines.launch

class AddStudentViewModel(private  val repository: Repository):ViewModel() {
    fun addStudent(student: Student){
        viewModelScope.launch {
            try {
                repository.insertStudent(student)
            } catch (e:Exception){
                Log.d("error",e.message.toString())
            }
        }
    }
}