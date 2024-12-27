package com.example.rsocialapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rsocialapp.adapters.FeedAdapter

class FeedFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var feedAdapter: FeedAdapter
    private val postsList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewFeed)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        // Cargar algunos datos de ejemplo
        postsList.addAll(listOf("Post 1", "Post 2", "Post 3", "Post 4"))

        feedAdapter = FeedAdapter(postsList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = feedAdapter
    }
}