package com.chaudharynabin6.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.search -> {
                Log.i("option menu item1","selected")
                true
            }
            R.id.view -> {
                Log.i("option menu item2","selected")
                true
            }
            R.id.profile ->{
                Log.i("option menu profile","clicked")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}