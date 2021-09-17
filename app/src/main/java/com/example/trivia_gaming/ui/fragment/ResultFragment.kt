package com.example.trivia_gaming.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.*
import com.example.trivia_gaming.R
import com.example.trivia_gaming.data.DataManager
import com.example.trivia_gaming.databinding.FragmentResultBinding

class ResultFragment: BaseFragment<FragmentResultBinding>(){
    private var result = DataManager.results
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentResultBinding
        get() = FragmentResultBinding::inflate
    override fun setup() {
    }
    override fun callBack() {
    }

    override fun onStart() {
        super.onStart()
        resultSetup()
    }
    private fun resultSetup(){
        binding.scoreText.text = result.toString()
        when {
            result < 50 -> {
                binding.scoreText.setTextColor(getColor(requireContext(),R.color.red))
            }
            result > 70 -> {
                binding.scoreText.setTextColor(getColor(requireContext(),R.color.dark_green))
            }
            else -> {
                binding.scoreText.setTextColor(getColor(requireContext(),R.color.black))
            }
        }
    }

}
