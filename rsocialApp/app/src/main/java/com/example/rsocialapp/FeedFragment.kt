package com.example.rsocialapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FeedFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val postViewModel: PostViewModel by activityViewModels()
    private lateinit var adapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = PostAdapter()
        recyclerView.adapter = adapter

        postViewModel.posts.observe(viewLifecycleOwner, { posts ->
            adapter.submitList(posts)
        })

        return view
    }
}