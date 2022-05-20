package com.chaudharynabin6.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.Menu.NONE
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class ChangingMenuItemAtRuntime : AppCompatActivity() {
    var mClicked = false
    var mI = 0
    lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changing_menu_item_at_runtime)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.changing_menu_item_at_runtime, menu)
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(mClicked) {
            for(item in 0..mI){
            val itemMenu = menu?.add(NONE, item, item, "help $item")
                if(item % 2 == 0){
                    itemMenu?.apply {
                        isEnabled = false
                    }
                }
            }
            this.mI++
        }

        super.onPrepareOptionsMenu(menu)
        mClicked = false
        return true

    }

    fun addMenu(view: View) {


        mClicked = true
        invalidateOptionsMenu()
        Toast.makeText(this, "menu added", Toast.LENGTH_SHORT).show()
    }


}