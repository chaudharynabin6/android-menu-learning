package com.chaudharynabin6.menu.multipleMenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.chaudharynabin6.menu.R

class MultipleMenu2 : Menus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_menu2)
    }
    private fun navigate(){
        val intent = Intent(this,MultipleMenu1::class.java)
        startActivity(intent)
    }
    fun navigateToMenu1(view: View) {
        navigate()
    }
}