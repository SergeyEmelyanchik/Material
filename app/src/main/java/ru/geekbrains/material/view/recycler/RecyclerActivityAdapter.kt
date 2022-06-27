package ru.geekbrains.material.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.material.databinding.ActivityRecyclerItemEarthBinding
import ru.geekbrains.material.databinding.ActivityRecyclerItemHeaderBinding
import ru.geekbrains.material.databinding.ActivityRecyclerItemMarsBinding

const val TYPE_EARTH = 1
const val TYPE_MARS = 2
const val TYPE_HEADER = 3

class RecyclerActivityAdapter(private var onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private lateinit var list: MutableList<Data>


    fun setList(newList: List<Data>) {
        this.list = newList.toMutableList()
    }

    fun setAddToList(newList: List<Data>, position: Int) {
        this.list = newList.toMutableList()
        notifyItemChanged(position)
    }

    fun setRemoveToList(newList: List<Data>, position: Int) {
        this.list = newList.toMutableList()
        notifyItemRemoved(position)
    }


    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EARTH -> {
                val view =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(view.root)
            }
            TYPE_MARS -> {
                val view =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
            TYPE_HEADER -> {
                val view =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(view.root)
            }
            else -> {
                val view =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) { // TODO WH создать BaseViewHolder
            TYPE_EARTH -> {
                (holder as EarthViewHolder).myBind(list[position])
            }
            TYPE_MARS -> {
                (holder as MarsViewHolder).myBind(list[position])
            }
            TYPE_HEADER -> {
                (holder as HeaderViewHolder).myBind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class EarthViewHolder(view: View) : RecyclerView.ViewHolder(view) { // TODO WH :BaseViewHolder
        fun myBind(data: Data) {
            /*(itemView as ConstraintLayout).findViewById<TextView>(R.id.title).text = data.someText
            (itemView as ConstraintLayout).findViewById<TextView>(R.id.descriptionTextView).text = data.someDescription*/

            /*val binding = ActivityRecyclerItemEarthBinding.bind(itemView)
            binding.title.text =data.someText
            binding.descriptionTextView.text = data.someDescription*/

            (ActivityRecyclerItemEarthBinding.bind(itemView)).apply {
                title.text = data.someText
                descriptionTextView.text = data.someDescription
            }
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) { // TODO WH :BaseViewHolder
        fun myBind(data: Data) {
            (ActivityRecyclerItemHeaderBinding.bind(itemView)).apply {
                header.text = data.someText
            }
        }
    }

    inner class MarsViewHolder(view: View) :
        RecyclerView.ViewHolder(view) { // TODO WH :BaseViewHolder
        fun myBind(data: Data) {
            (ActivityRecyclerItemMarsBinding.bind(itemView)).apply {
                title.text = data.someText
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition)
                }
                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveBtnClick(layoutPosition)
                }
                moveItemDown.setOnClickListener { // TODO IndexOutOfBoundsException
                    list.removeAt(layoutPosition).apply {
                        list.add(layoutPosition + 1, this)
                    }
                    notifyItemMoved(layoutPosition, layoutPosition + 1)
                }
                moveItemUp.setOnClickListener { // TODO IndexOutOfBoundsException: Index: -1
                    list.removeAt(layoutPosition).apply {
                        list.add(layoutPosition - 1, this)
                    }
                    notifyItemMoved(layoutPosition, layoutPosition - 1)
                }
            }
        }
    }
}