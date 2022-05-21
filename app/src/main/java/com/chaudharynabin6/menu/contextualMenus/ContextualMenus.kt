package com.chaudharynabin6.menu.contextualMenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaudharynabin6.menu.R

class ContextualMenus : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
    lateinit var list: MutableList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contextual_menus)


        val recyclerView = this.findViewById<RecyclerView>(R.id.recycler_view_contextual_menus)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter()
        list = mutableListOf(
            Note("recycler view item 1", 1),
            Note("recycler view item 2", 2)
        )
        adapter.submitList(list)
        recyclerView.adapter = adapter
        val button = this.findViewById<Button>(R.id.button_contextual)
        registerForContextMenu(recyclerView)
    }

    fun fillItem(view: View) {
//        pass new list other wise the recycler view will not update
//        https://stackoverflow.com/questions/49726385/listadapter-not-updating-item-in-recyclerview
//        it's not the job of presentation layer to check data what to present
        val list = mutableListOf(
            Note("recycler view item 1", 1),
            Note("recycler view item 2", 2),
            Note("recycler view item 3", 3),
            Note("recycler view item 4", 4)
        )
//        list.addAll(this.list)
//        Log.e("list", list.toString())
        adapter.submitList(
            list
        )
    }
//
//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?,
//        menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        this.menuInflater.inflate(R.menu.contextual_menu,menu)
//    }

//    you can only implement onContextItemSelected here
    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when (item.title.toString()) {
//            R.id.item1 -> {
//               Log.e("CONTEXT MENU SELECTED","item1 ${adapter.id.toString()}")
//
//                true
//            }
//            R.id.item2 -> {
//                Log.e("CONTEXT MENU SELECTED","item2 ${adapter.id.toString()}")
//
//                true
//            }
//            1 -> {
//                Log.e("CONTEXT MENU SELECTED","${item.title}")
//                true
//            }
            "R1" -> {
                Log.e("CONTEXT MENU SELECTED", "${item.title}")
                true
            }
            "R2" -> {
                Log.e("CONTEXT MENU SELECTED", "${item.title}")
                true
            }
            "R3" ->{
                Log.e("CONTEXT MENU SELECTED", "${item.title}")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }


}