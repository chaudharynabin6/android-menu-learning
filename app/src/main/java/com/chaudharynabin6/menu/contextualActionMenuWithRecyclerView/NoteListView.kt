package com.chaudharynabin6.menu.contextualActionMenuWithRecyclerView

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.chaudharynabin6.menu.databinding.ContextualMenuItemsBinding

class NoteListView(val context: Activity, var notes: MutableList<Note>) : BaseAdapter() {
    override fun getCount(): Int {
        return notes.size
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return notes[position].id.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = ContextualMenuItemsBinding.inflate(context.layoutInflater)
        inflater.contextualMenuText.text = notes[position].title
        if(notes[position].isSelected){
            inflater.root.isActivated = true
            inflater.root.setBackgroundColor(Color.GRAY)
        }
        else{
            inflater.root.isSelected = false
            inflater.root.setBackgroundColor(Color.TRANSPARENT)
        }
        return inflater.root
    }



    fun deleteItem() {
        val toRemoveNotes = mutableListOf<Note>()
        for (note in notes){
            if(note.isSelected){
                toRemoveNotes.add(note)
            }
        }
        notes.removeAll(toRemoveNotes)
        notifyDataSetChanged()

    }





}