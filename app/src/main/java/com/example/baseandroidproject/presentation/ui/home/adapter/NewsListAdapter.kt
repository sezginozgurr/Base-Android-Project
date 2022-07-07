package com.example.baseandroidproject.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.baseandroidproject.R
import com.example.baseandroidproject.data.model.Article
import com.example.baseandroidproject.databinding.ItemNewsListBinding

class NewsListAdapter(
    private val click: (Article) -> Unit
) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    var items: List<Article> = arrayListOf()
        set(value) {
            //val diffUtil = BaseDiffCallBack(field, value)
            //val diffResults = DiffUtil.calculateDiff(diffUtil)
            field = value
            //diffResults.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: ItemNewsListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news_list, parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position], click)
    }

    inner class NewsViewHolder(private val binding: ItemNewsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Article, click: (Article) -> Unit) {
            binding.data = data
            binding.executePendingBindings()

            itemView.setOnClickListener {
                click(data)
            }
        }
    }
}