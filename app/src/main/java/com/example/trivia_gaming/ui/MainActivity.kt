package com.example.trivia_gaming.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.trivia_gaming.R
import com.example.trivia_gaming.databinding.ActivityMainBinding
import com.example.trivia_gaming.ui.fragment.InitialFragment
import com.example.trivia_gaming.ui.fragment.ResultFragment
import com.example.trivia_gaming.ui.fragment.StartFragment
import com.example.trivia_gaming.util.Interface

class MainActivity : AppCompatActivity(),Interface {
    private lateinit var binding: ActivityMainBinding
    override val myInitialFragment = InitialFragment(this)
    override val myStartFragment = StartFragment(this)
    override val myResultFragment= ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }
    private fun setup() {
        addFragment(myInitialFragment)
    }

    override fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}