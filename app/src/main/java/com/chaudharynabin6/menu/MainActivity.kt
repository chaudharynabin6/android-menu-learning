package com.chaudharynabin6.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.chaudharynabin6.menu.multipleMenu.MultipleMenu1
import com.chaudharynabin6.menu.multipleMenu.MultipleMenu2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.game_menu, menu)
        return true
    }

    fun navigateToChangingMenuItemAtRuntime(){
        val intent = Intent(this,ChangingMenuItemAtRuntime::class.java)
        startActivity(intent)
    }
    private fun navigateToMultipleMenu1(){
        val intent = Intent(this,MultipleMenu1::class.java)
        startActivity(intent)
    }

    private fun navigateToMultipleMenu2(){
        val intent = Intent(this, MultipleMenu2::class.java)
        startActivity(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.search -> {
                Log.i("option menu item1","selected")
                navigateToChangingMenuItemAtRuntime()
                true
            }
            R.id.view -> {
                Log.i("option menu item2","selected")
                navigateToMultipleMenu1()
                true
            }
            R.id.profile ->{
                Log.i("option menu profile","clicked")
                navigateToMultipleMenu2()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}