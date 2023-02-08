package com.asascompany.foodlist.View.Food

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asascompany.foodlist.SharedPrefs
import com.asascompany.foodlist.databinding.FoodItemBinding

class FoodAdapter(val settings: SharedPrefs) : ListAdapter<FoodData, RecyclerView.ViewHolder>(
    DIFF_CALLBACK
){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodData>() {

            override fun areItemsTheSame(oldItem: FoodData, newItem: FoodData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: FoodData, newItem: FoodData): Boolean {
                return oldItem.name == newItem.name || oldItem.img == newItem.img || oldItem.hashCode() == newItem.hashCode()
            }

        }
    }

    private lateinit var binding: FoodItemBinding
    var onItemClick: ((FoodData) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: FoodItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: FoodData) {
            itemBinding.tvName.text = item.name
//            itemBinding.tvName.textSize = settings.getFontSize()
            itemBinding.tvName.setOnClickListener {
                Toast.makeText(it.context, "click on the icon for details", Toast.LENGTH_LONG).show()
            }
            itemBinding.ivAvatar.setImageResource(item.img)
        }

        init {
            itemBinding.itemContainer.setOnClickListener {
                onItemClick?.invoke(getItem(adapterPosition))
            }
        }
    }
}