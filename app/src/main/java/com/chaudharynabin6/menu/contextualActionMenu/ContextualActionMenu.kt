package com.chaudharynabin6.menu.contextualActionMenu


import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import com.chaudharynabin6.menu.R

class ContextualActionMenu : AppCompatActivity() {
    private var mActionMode: ActionMode? = null
    lateinit var textView: TextView

    private val mActionMenuCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//            inflate the menu resource
            mode?.apply {
                this.menuInflater.inflate(R.menu.contextual_action_menu, menu)
//                this.title = "Choose Action"
            }
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {

            return when (item?.title.toString()) {
                "search" -> {
                    Toast.makeText(this@ContextualActionMenu, "search selected", Toast.LENGTH_SHORT)
                        .show()
                    mode?.finish()
                    true
                }
                "copy" -> {

                    Toast.makeText(this@ContextualActionMenu, "copy selected", Toast.LENGTH_SHORT)
                        .show()
                    mode?.finish()
                    true
                }
                "delete" -> {

                    Toast.makeText(this@ContextualActionMenu, "delete selected", Toast.LENGTH_SHORT)
                        .show()
                    mode?.finish()
                    true
                }
                "select all" -> {

                    Toast.makeText(
                        this@ContextualActionMenu,
                        "select all selected",
                        Toast.LENGTH_SHORT
                    ).show()
                    mode?.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            mActionMode = null
            textView.setBackgroundColor(Color.TRANSPARENT)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contextual_action_menu)

        textView = findViewById<TextView>(R.id.contextual_text_view)
        textView.setOnLongClickListener(View.OnLongClickListener { v: View? ->
            if (mActionMode != null) {
                return@OnLongClickListener false
            }
            mActionMode = startSupportActionMode(mActionMenuCallback)
            v?.apply {
                isSelected=true
                this.setBackgroundColor(Color.BLUE)
            }
            true
        })
    }
}