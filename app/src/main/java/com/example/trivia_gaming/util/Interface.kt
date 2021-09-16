package com.example.trivia_gaming.util

import androidx.fragment.app.Fragment

interface Interface {
    fun addFragment(fragment: Fragment)
    fun replaceFragment(fragment: Fragment)
    val myInitialFragment: Fragment
    val myStartFragment: Fragment
    val myResultFragment: Fragment
}