package com.dicoding.programminglist

import android.app.DownloadManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardHeroAdapter(private var listLang: ArrayList<Lang>) :
    RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Lang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val lang = listLang[position]

        Glide.with(holder.itemView.context)
            .load(lang.photo)
            .apply(RequestOptions().override(400,450))
            .into(holder.imgPhoto)

        holder.tvName.text = lang.name
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listLang[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listLang.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}