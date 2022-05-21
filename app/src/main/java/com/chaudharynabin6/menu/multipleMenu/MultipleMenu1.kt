package com.chaudharynabin6.menu.multipleMenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.chaudharynabin6.menu.R

class MultipleMenu1 : Menus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_menu1)
    }
    private fun navigate(){
        val intent = Intent(this,MultipleMenu2::class.java)
        startActivity(intent)
    }
    fun navigateToMenu2(view: View) {
        navigate()
    }
}