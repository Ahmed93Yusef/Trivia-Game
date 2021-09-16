package com.example.trivia_gaming.util

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trivia_gaming.R
import com.example.trivia_gaming.data.domain.Results
import com.example.trivia_gaming.databinding.ItemCardBinding

class ItemAdapter(private var list: List<Results>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = R.layout.item_card
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            val listItem = listOf(
                textAnswer1,
                textAnswer2,
                textAnswer3,
                textAnswer4
            ).shuffled()
            with(list[position]){
                val questionText = "Q${position+1}: $question"
                textQuestion.text = questionText
                listItem[0].text = correctAnswer
                listItem[1].text = incorrectAnswers?.get(0)
                listItem[2].text = incorrectAnswers?.get(1)
                listItem[3].text = incorrectAnswers?.get(2)
            }
            listItem.forEach { it.isSelected = true }
        }
    }
    override fun getItemCount() = list.size
    class ItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemCardBinding.bind(viewItem)
    }
}