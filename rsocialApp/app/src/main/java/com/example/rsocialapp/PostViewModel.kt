package com.example.rsocialapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>(emptyList())
    val posts: LiveData<List<Post>> get() = _posts

    fun addPost(post: Post) {
        val currentList = _posts.value?.toMutableList() ?: mutableListOf()
        currentList.add(post)
        _posts.value = currentList // Actualiza la lista de posts
    }
}