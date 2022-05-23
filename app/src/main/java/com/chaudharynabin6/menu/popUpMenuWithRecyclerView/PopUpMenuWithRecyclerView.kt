package com.chaudharynabin6.menu.popUpMenuWithRecyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chaudharynabin6.menu.databinding.ActivityPopUpMenuWithRecyclerViewBinding

class PopUpMenuWithRecyclerView : AppCompatActivity(),IPopUpRecyclerView {
    private lateinit var binding: ActivityPopUpMenuWithRecyclerViewBinding
    lateinit var adapter: PopUpRecyclerView
    var notes = mutableListOf<Note>(
        Note("note 1", 1),
        Note("note 2", 2),
        Note("note 3", 3),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpMenuWithRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PopUpRecyclerView(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(notes)

    }

   fun deleteNote(position : Int){
        notes.removeAt(position)
//       val newNotes = mutableListOf<Note>()
//       newNotes.addAll(notes)
//        adapter.submitList(newNotes)
       adapter.submitList(notes)
       adapter.notifyItemRemoved(position)
    }

    override fun iDeleteNote(position: Int) {
        notes.removeAt(position)
        adapter.submitList(notes)
        adapter.notifyItemRemoved(position)
    }


}