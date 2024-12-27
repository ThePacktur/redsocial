package com.example.rsocialapp.com.example.rsocialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsocialapp.R

class FriendAdapter(private val friendsList: List<String>) :
    RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friendsList[position])
    }

    override fun getItemCount(): Int = friendsList.size

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)

        fun bind(name: String) {
            tvFriendName.text = name
        }
    }
}