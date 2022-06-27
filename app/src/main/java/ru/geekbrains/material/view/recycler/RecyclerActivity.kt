package ru.geekbrains.material.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.material.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), OnListItemClickListener {


    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: RecyclerActivityAdapter

    private val list = arrayListOf(
        Pair(Data("HEADER", "", TYPE_HEADER), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Mars", "Mars des", TYPE_MARS), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Mars", "Mars des", TYPE_MARS), false)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lon = 1
        val lat = 2
        val temp = 20
        val loc = Pair(lon, lat)
        val loc2 = lon to lat
        loc.first
        loc.second
        val weather = Triple(lon, lat, temp)
        val weather2 = lon to lat to temp

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
        list.add(position, Pair(Data("Mars", "Mars des", TYPE_MARS), false))
        adapter.setAddToList(list, position)
    }

    override fun onRemoveBtnClick(position: Int) {
        list.removeAt(position)
        adapter.setRemoveToList(list, position)

    }
}