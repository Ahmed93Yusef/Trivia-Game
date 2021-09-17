package com.example.trivia_gaming.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.trivia_gaming.R
import com.example.trivia_gaming.data.DataManager
import com.example.trivia_gaming.databinding.FragmentInitialBinding
import com.example.trivia_gaming.util.Constant
import com.example.trivia_gaming.util.Interface


class InitialFragment(private val replace: Interface?) : BaseFragment<FragmentInitialBinding>(){
    private val bundle =Bundle()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentInitialBinding
        get() = FragmentInitialBinding::inflate
    override fun setup() {
        setSpinner()
    }

    override fun callBack() {
        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.startButton.setOnClickListener {
            sendDataFunction()
            replace?.replaceFragment(replace.myStartFragment)
        }

    }
    private fun setSpinner(){
        val items = DataManager.difficultyList
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.spinner.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun sendDataFunction() {
        binding.apply {
            val numberOfQuestions = amountEditText.editText?.text.toString()
            val categoryType =categoryEditText.editText?.text.toString()
            var difficulty = "easy"
            setSpinner.setOnItemClickListener { _, _, i, _ ->
                difficulty = DataManager.difficultyList[i]
            }
            val argument = bundle.apply {
                putString(Constant.KEY_QUESTION_NUMBER , numberOfQuestions)
                putString(Constant.KEY_CATEGORY_TYPE , categoryType)
                putString(Constant.KEY_DIFFICULTY , difficulty)
            }

            replace?.myStartFragment?.arguments = argument

        }

    }
}