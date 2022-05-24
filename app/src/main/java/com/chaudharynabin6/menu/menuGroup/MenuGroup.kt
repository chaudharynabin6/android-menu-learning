package com.chaudharynabin6.menu.menuGroup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.chaudharynabin6.menu.R
import com.chaudharynabin6.menu.databinding.ActivityMenuGroupBinding

class MenuGroup : AppCompatActivity() {
    private lateinit var binding : ActivityMenuGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.toolbar.title = "Android Menu Group Example"
//        binding.toolbar.setTitleTextColor(Color.WHITE)
//        binding.toolbar.setBackgroundColor(Color.parseColor("#FFB3AF8F"))
//        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu_group,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.text_bold -> {
                Log.d("bold","bold item selected")
                true
            }
            else -> {
                false
            }
        }
    }

}