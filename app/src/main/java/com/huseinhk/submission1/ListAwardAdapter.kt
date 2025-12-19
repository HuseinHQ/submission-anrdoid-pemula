package com.huseinhk.submission1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huseinhk.submission1.databinding.ItemRowAwardBinding

class ListAwardAdapter(private val listAward: ArrayList<Award>) :
    RecyclerView.Adapter<ListAwardAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding =
            ItemRowAwardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        val (category, title, image) = listAward[position]
        holder.binding.imgItemPhoto.setImageResource(image)
        holder.binding.tvItemCategory.text = category
        holder.binding.tvItemTitle.text = title

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listAward[holder.bindingAdapterPosition]) }
    }

    override fun getItemCount(): Int = listAward.size

    class ListViewHolder(var binding: ItemRowAwardBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgPhoto = binding.imgItemPhoto
        val tvCategory = binding.tvItemCategory
        val tvTitle = binding.tvItemTitle
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Award)
    }
}