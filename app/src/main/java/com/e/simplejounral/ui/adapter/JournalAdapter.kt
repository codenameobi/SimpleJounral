package com.e.simplejounral.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e.simplejounral.R
import com.e.simplejounral.data.Journal
import com.e.simplejounral.utils.ctx
import kotlinx.android.synthetic.main.item_journal.view.*


class JournalAdapter(private var journals: List<Journal>) : ListAdapter<Journal, JournalAdapter.JournalViewHolder>(JournalsComparator()) {
    class JournalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(journal: Journal){
            itemView.title.text = journal.title
            itemView.date.text = journal.date.toString()
            itemView.body.text = journal.body
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_journal, parent, false)
        return JournalViewHolder(view)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class JournalsComparator : DiffUtil.ItemCallback<Journal>() {
        override fun areItemsTheSame(oldItem: Journal, newItem: Journal): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Journal, newItem: Journal): Boolean {
            return oldItem.title == newItem.title
        }
    }


}