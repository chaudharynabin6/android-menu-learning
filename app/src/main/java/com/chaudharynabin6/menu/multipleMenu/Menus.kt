package com.chaudharynabin6.menu.multipleMenu

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaudharynabin6.menu.R

open class Menus() : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         this.menuInflater.inflate(R.menu.mutiple_menu,menu)
        return true
    }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.title){
            "item1" -> {

                Toast.makeText(this,"item 1 clicked",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}