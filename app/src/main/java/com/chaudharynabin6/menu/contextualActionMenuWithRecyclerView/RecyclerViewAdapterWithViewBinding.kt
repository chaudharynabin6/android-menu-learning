package com.chaudharynabin6.menu.contextualActionMenuWithRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chaudharynabin6.menu.contextualMenus.Note
import com.chaudharynabin6.menu.databinding.ContextualMenuItemsBinding


class RecyclerViewAdapterWithViewBinding :
    ListAdapter<Note, RecyclerViewAdapterWithViewBinding.RecyclerViewHolder>(ItemComparator()) {
    var id : Int? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val viewHolder = RecyclerViewHolder.create(parent)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val noteItem = getItem(position)
        holder.bind(noteItem)
    }

    class RecyclerViewHolder(itemView: ContextualMenuItemsBinding) : RecyclerView.ViewHolder(itemView.root){

        val title = itemView.contextualMenuText
        fun bind(note: Note) {
            this.title.text = note.title
        }


        companion object {
            fun create(parent: ViewGroup): RecyclerViewHolder {
                val binding = ContextualMenuItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return RecyclerViewHolder(binding)
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

