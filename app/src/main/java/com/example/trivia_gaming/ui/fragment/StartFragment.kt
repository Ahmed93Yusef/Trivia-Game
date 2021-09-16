package com.example.trivia_gaming.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trivia_gaming.data.DataManager
import com.example.trivia_gaming.util.NetWork
import com.example.trivia_gaming.databinding.FragmentStartBinding
import com.example.trivia_gaming.util.ItemAdapter

class StartFragment : BaseFragment<FragmentStartBinding>(){
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStartBinding
        get() = FragmentStartBinding::inflate
    override fun setup() {
        DataManager.getUrl(amount = 10,category = 10,difficulty = "easy")
        adapterSetFunction()
    }
    override fun callBack() {
    }


    private fun adapterSetFunction() {
        val adapter = ItemAdapter(DataManager.dataGame)
        NetWork.makeRequestUsingOkhttp(requireActivity(),adapter)
        binding.recycleView.adapter = adapter
    }
}