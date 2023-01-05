package com.codelabs.musisifavorit

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codelabs.musisifavorit.databinding.ItemRowFilmBinding

class ListFilmAdapter(private val list: ArrayList<Films>):
    RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding : ItemRowFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(films: Films){
            with(binding){
                tvFilmName.text = films.name
                tvDetail.text = films.detail
                Glide.with(itemView.context)
                    .load(films.photo)
                    .apply(RequestOptions().override(260, 260))
                    .into(ivFilm)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, films)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowFilmBinding.inflate((LayoutInflater.from(parent.context)),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}