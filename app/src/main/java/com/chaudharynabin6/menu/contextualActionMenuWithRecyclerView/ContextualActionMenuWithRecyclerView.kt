package com.chaudharynabin6.menu.contextualActionMenuWithRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.AbsListView.*
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.LinearLayoutManager
import com.chaudharynabin6.menu.R
import com.chaudharynabin6.menu.contextualMenus.Note
import com.chaudharynabin6.menu.databinding.ActivityContextualActionMenuWithRecyclerViewBinding
import com.chaudharynabin6.menu.databinding.ContextualMenuItemsBinding

class ContextualActionMenuWithRecyclerView : AppCompatActivity() {

    private val listener = object  : MultiChoiceModeListener{
        override fun onCreateActionMode(mode: android.view.ActionMode?, menu: Menu?): Boolean {
            val menuInflater: MenuInflater = mode!!.menuInflater
            menuInflater.inflate(R.menu.contextual_action_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: android.view.ActionMode?, menu: Menu?): Boolean {

            return false
        }

        override fun onActionItemClicked(mode: android.view.ActionMode?, item: MenuItem?): Boolean {
           return false
        }

        override fun onDestroyActionMode(mode: android.view.ActionMode?) {

        }

        override fun onItemCheckedStateChanged(
            mode: android.view.ActionMode?,
            position: Int,
            id: Long,
            checked: Boolean
        ) {
         
        }


    }

    private val list  = mutableListOf<Note>(
        Note("item 1",1),
        Note("item 2",2),
        Note("item 3",3),
        Note("item 4",4),
        )
    private lateinit var binding: ActivityContextualActionMenuWithRecyclerViewBinding
    private lateinit var adapter : RecyclerViewAdapterWithViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityContextualActionMenuWithRecyclerViewBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)

        adapter = RecyclerViewAdapterWithViewBinding()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(list)
        list.add(
            Note("item 5",5),
            )
        adapter.submitList(list)


    }


}