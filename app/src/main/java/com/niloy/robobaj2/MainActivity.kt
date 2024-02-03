package com.niloy.robobaj2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.niloy.robobaj2.db.StudentDb
import com.niloy.robobaj2.navigation.NavItem
import com.niloy.robobaj2.navigation.SetNavGraph
import com.niloy.robobaj2.ui.theme.Robobaj2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, StudentDb::class.java, "student_db")
            .build()
        val repository = Repository(db)
        setContent {
            Robobaj2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    SetNavGraph(navHostController = navHostController, startDestination = NavItem.Main.route, repository = repository)
                }
            }
        }
    }
}
