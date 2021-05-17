package com.example.sixthproject.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sixthproject.data.source.local.entity.TvShowsEntity
import com.example.sixthproject.databinding.ItemsTvShowsBinding
import com.example.sixthproject.ui.tvshowdetail.TvShowDetailActivity

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private var listTvShows = ArrayList<TvShowsEntity>()

    fun setTvShows(tvShows: List<TvShowsEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }
 
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemsTvShowsBinding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val movie = listTvShows[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listTvShows.size
 

    class TvShowsViewHolder(private val binding: ItemsTvShowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, TvShowDetailActivity::class.java)
                    intent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShows.tvShowId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShows.image)
                    .apply(RequestOptions().override(600, 500))
                    .into(tvShowsPoster)
            }
        }
    }
}