package com.chaudharynabin6.menu.contextualActionMenuWithRecyclerView

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AbsListView
import androidx.appcompat.app.AppCompatActivity
import com.chaudharynabin6.menu.R
import com.chaudharynabin6.menu.databinding.ActivityContextualActionMenuWithListViewBinding

class ContextualActionMenuWithListView : AppCompatActivity() {


    private val listener = object : AbsListView.MultiChoiceModeListener {
        override fun onCreateActionMode(mode: android.view.ActionMode?, menu: Menu?): Boolean {
            val menuInflater: MenuInflater = mode!!.menuInflater
            menuInflater.inflate(R.menu.contextual_action_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: android.view.ActionMode?, menu: Menu?): Boolean {

            return false
        }

        override fun onActionItemClicked(mode: android.view.ActionMode?, item: MenuItem?): Boolean {
            return when (item?.title.toString()) {

                "delete" -> {
                    adapter.deleteItem(selectionPosition)
                    mode?.finish()
                    true
                }
                else -> false
            }

        }

        override fun onDestroyActionMode(mode: android.view.ActionMode?) {
                for(note in adapter.notes){
                    note.isSelected = false
                }
                adapter.notifyDataSetChanged()
                selectionPosition.clear()
        }

        override fun onItemCheckedStateChanged(
            mode: android.view.ActionMode?,
            position: Int,
            id: Long,
            checked: Boolean
        ) {
            Log.e("CHECKED STATE CHANGED", "$position $id $checked+")
            selectionPosition.add(Selection(id, checked))
            adapter.itemSelected(selectionPosition)
        }


    }

    data class Selection(var id: Long, var isSelected: Boolean)

    private val selectionPosition = mutableSetOf<Selection>()
    private val list = mutableListOf<Note>(
        Note("item 1", 1,false),
        Note("item 2", 2,false),
        Note("item 3", 3,false),
        Note("item 4", 4,false),
    )
    lateinit var binding: ActivityContextualActionMenuWithListViewBinding
    lateinit var adapter: NoteListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContextualActionMenuWithListViewBinding.inflate(layoutInflater)
        adapter = NoteListView(this, list)
        binding.listView.adapter = adapter
        binding.listView.choiceMode = AbsListView.CHOICE_MODE_MULTIPLE_MODAL
        binding.listView.setMultiChoiceModeListener(listener)
        setContentView(binding.root)
    }
}