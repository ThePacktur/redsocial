package com.example.rsocialapp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    // Número de pestañas
    override fun getItemCount(): Int = 3

    // Crear el fragmento correspondiente para cada pestaña
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedFragment()      // Fragment para Feed
            1 -> PostFragment()      // Fragment para Post
            2 -> FriendFragment()   // Fragment para Friends
            else -> FeedFragment()
        }
    }
}