package com.chaudharynabin6.menu.contextualMenus

import android.util.Log
import android.view.*
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chaudharynabin6.menu.R

class RecyclerViewAdapter :
    ListAdapter<Note, RecyclerViewAdapter.RecyclerViewHolder>(ItemComparator()) {
    var id : Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val viewHolder = RecyclerViewHolder.create(parent)
//        viewHolder.itemView.setOnCreateContextMenuListener{
//            a,b,c ->
//            this.id = getItem(viewHolder.adapterPosition).id
//
//            Log.d("context","context menu opened")
//        }
        viewHolder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
            menu.add(Menu.NONE,1,1,"R1")
            menu.add(Menu.NONE,2,2,"R2")
            menu.add(Menu.NONE,3,3,"R3")
        }


        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val noteItem = getItem(position)
        holder.bind(noteItem)
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title = itemView.findViewById<TextView>(R.id.contextual_menu_text)

        fun bind(note: Note) {
            this.title.text = note.title
        }


        companion object {
            fun create(parent: ViewGroup): RecyclerViewHolder {
                val parentGroupView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.contextual_menu_items, parent, false)

                return RecyclerViewHolder(parentGroupView)
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

