package com.chaudharynabin6.menu.popUpMenuWithRecyclerView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chaudharynabin6.menu.R
import com.chaudharynabin6.menu.databinding.PopUpListItemsBinding


class PopUpRecyclerView(var context : IPopUpRecyclerView) :
    ListAdapter<Note, PopUpRecyclerView.RecyclerViewHolder>(ItemComparator()) {
    var id: Int? = null
//    var mContext: PopUpMenuWithRecyclerView = context as PopUpMenuWithRecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = PopUpListItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val noteItem = getItem(position)
        holder.bind(noteItem)
    }

   inner class RecyclerViewHolder(itemView: PopUpListItemsBinding) :
        RecyclerView.ViewHolder(itemView.root), View.OnClickListener,
        PopupMenu.OnMenuItemClickListener {

        val title = itemView.text
        val image = itemView.image

        init {
            image.setOnClickListener(this)
        }
        fun bind(note: Note) {
            this.title.text = note.text
        }






        override fun onClick(v: View?) {
            Log.d("POP UP ON CLICK","current position $adapterPosition")
            showPopUpMenu(v!!)
        }

        private fun showPopUpMenu(v: View) {
            val popUpMenu = PopupMenu(v.context,v)
            popUpMenu.inflate(R.menu.contextual_action_menu)
            popUpMenu.setOnMenuItemClickListener(this)
            popUpMenu.show()
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {

            return when(item?.title.toString()){
                "delete" -> {
//                   val note =  this@PopUpRecyclerView.getItem(this.adapterPosition)
                    Log.d("adapter position ","$adapterPosition")
//                    this@PopUpRecyclerView.mContext.deleteNote(adapterPosition)
                    context.iDeleteNote(adapterPosition)
                    true
                }
                else -> {
                    false
                }
            }
        }


    }
}



class ItemComparator : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

}

interface IPopUpRecyclerView {
    fun iDeleteNote(position : Int)
}