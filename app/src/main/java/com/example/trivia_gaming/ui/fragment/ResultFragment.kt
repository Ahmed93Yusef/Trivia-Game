package com.example.trivia_gaming.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trivia_gaming.databinding.FragmentResultBinding

class ResultFragment: BaseFragment<FragmentResultBinding>(){
    override fun setup() {
    }

    override fun callBack() {
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentResultBinding
        get() = FragmentResultBinding::inflate
}
