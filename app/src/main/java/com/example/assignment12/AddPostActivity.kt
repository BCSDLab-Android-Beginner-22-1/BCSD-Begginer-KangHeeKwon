package com.example.assignment12

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment12.databinding.ActivityAddContentBinding
import com.example.assignment12.databinding.ActivityMainBinding

class AddPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_content)
        binding = ActivityAddContentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java)
            returnIntent.putExtra("Title", binding.editTextTitle.text.toString())
            returnIntent.putExtra("Content", binding.editTextContent.text.toString())
            returnIntent.putExtra("Name", binding.editTextName.text.toString())
            setResult(100, returnIntent)
            finish()
        }

    }


}