package com.example.trivia_gaming.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trivia_gaming.databinding.FragmentInitialBinding
import com.example.trivia_gaming.util.Interface


class InitialFragment(private val replace : Interface) : BaseFragment<FragmentInitialBinding>(){
    private val myStartFragment = StartFragment()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentInitialBinding
        get() = FragmentInitialBinding::inflate
    override fun setup() {

    }

    override fun callBack() {
        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.startButton.setOnClickListener {
            replace.replaceFragment(myStartFragment)
        }
    }
}