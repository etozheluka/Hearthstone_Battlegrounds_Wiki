package com.example.dota2herowiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2herowiki.dataHolder.DataModel
import com.example.dota2herowiki.databinding.GridViewBinding

typealias onClick = (card: DataModel.Card) -> Unit

class MyListAdapter:ListAdapter<DataModel.Card,MyListAdapter.ViewHolder>(DiffCallBack()) {

    lateinit var onClick: onClick
    private var content = emptyList<DataModel.Card?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            GridViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class DiffCallBack: DiffUtil.ItemCallback<DataModel.Card>() {
        override fun areItemsTheSame(oldItem: DataModel.Card, newItem: DataModel.Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataModel.Card, newItem: DataModel.Card): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: GridViewBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var currentCard: DataModel.Card
        fun bind(){
            currentCard = getItem(adapterPosition)
            if(currentCard.battlegrounds?.hero == false){
                binding.apply {
                    Glide.with(this.root).load(currentCard.battlegrounds?.image).into(imageView)
//                    root.setOnClickListener {
//                        onClick(
//                            currentCard
//                        )
//                    }
                }
            }

        }

    }
    fun setData(newList: List<DataModel.Card?>){
        content = newList
        submitList(content)
    }


}