package com.example.hw_8_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.hw_8_3.databinding.ItemMultBinding

class MultAdapter(
    var multList:ArrayList<MultModel>,
    val onClick: (model:MultModel) -> Unit
): Adapter<MultAdapter.MultViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultViewHolder {
        return MultViewHolder(ItemMultBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return multList.size
    }

    override fun onBindViewHolder(holder: MultViewHolder, position: Int) {
        holder.bind(multList[position])
    }


    inner class MultViewHolder(private var binding:ItemMultBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item:MultModel){
            binding.tvCharacterName.text = item.name
            binding.tvCharacterExistence.text = item.exist
            Glide.with(binding.imgCharacter).load(item.image).into(binding.imgCharacter)

            itemView.setOnClickListener{
                onClick.invoke(item)
            }
        }

    }
}