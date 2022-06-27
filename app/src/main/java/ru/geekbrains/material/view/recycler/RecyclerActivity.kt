package ru.geekbrains.material.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.material.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), OnListItemClickListener {


    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: RecyclerActivityAdapter

    private val list = arrayListOf(
        Data("HEADER", "", TYPE_HEADER),
        Data("Earth", "Earth des", TYPE_EARTH),
        Data("Earth", "Earth des", TYPE_EARTH),
        Data("Mars", "Mars des", TYPE_MARS),
        Data("Earth", "Earth des", TYPE_EARTH),
        Data("Earth", "Earth des", TYPE_EARTH),
        Data("Earth", "Earth des", TYPE_EARTH),
        Data("Mars", "Mars des", TYPE_MARS)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerActivityAdapter(this)
        adapter.setList(list)
        binding.recyclerView.adapter = adapter

        binding.recyclerActivityFAB.setOnClickListener {
            onAddBtnClick(list.size)
        }
    }

    override fun onItemClick(data: Data) {

    }

    override fun onAddBtnClick(position: Int) {
        list.add(position, Data("Mars", "Mars des", TYPE_MARS))
        adapter.setAddToList(list, position)
    }

    override fun onRemoveBtnClick(position: Int) {
        list.removeAt(position)
        adapter.setRemoveToList(list, position)

    }
}