package com.example.rsocialapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rsocialapp.com.example.rsocialapp.FriendAdapter

class FriendFragment : Fragment() {

    private lateinit var recyclerViewFriends: RecyclerView
    private lateinit var adapter: FriendAdapter
    private val friendsList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friend, container, false)

        recyclerViewFriends = view.findViewById(R.id.recyclerViewFriends)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        // Datos simulados
        friendsList.addAll(listOf("Alice", "Bob", "Charlie", "Diana", "Eve"))

        adapter = FriendAdapter(friendsList)
        recyclerViewFriends.layoutManager = LinearLayoutManager(context)
        recyclerViewFriends.adapter = adapter
    }
}