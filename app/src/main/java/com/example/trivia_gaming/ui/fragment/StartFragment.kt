package com.example.trivia_gaming.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trivia_gaming.data.DataManager
import com.example.trivia_gaming.databinding.FragmentStartBinding
import com.example.trivia_gaming.util.Constant
import com.example.trivia_gaming.util.Interface
import com.example.trivia_gaming.util.ItemAdapter
import com.example.trivia_gaming.util.NetWork

class StartFragment(private val replace: Interface?) : BaseFragment<FragmentStartBinding>(){
    private val bundle = Bundle()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStartBinding
        get() = FragmentStartBinding::inflate
    override fun setup() {
        setUrlFunction()
        adapterSetFunction()
    }
    private fun setUrlFunction() {
        arguments?.let {
            val amount = it.getString(Constant.KEY_QUESTION_NUMBER)
            val category = it.getString(Constant.KEY_CATEGORY_TYPE)
            val difficulty = it.getString(Constant.KEY_DIFFICULTY)
            DataManager.getUrl(amount = amount,category = category,difficulty = difficulty)
        }
    }

    override fun callBack() {
        binding.resultButton.setOnClickListener {
            replace?.replaceFragment(replace.myResultFragment)
        }
    }
    private fun adapterSetFunction() {
        val adapter = ItemAdapter(DataManager.dataGame)
        NetWork.makeRequestUsingOkhttp(requireActivity(),adapter)
        binding.recycleView.adapter = adapter
    }
}