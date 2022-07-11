package com.example.assignment12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment12.databinding.ActivityAddContentBinding
import com.example.assignment12.databinding.ActivityModifyContentBinding

class ModifyPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityModifyContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_content)
        binding = ActivityModifyContentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java)
            returnIntent.putExtra("Title", binding.editTextTitle.text.toString())
            returnIntent.putExtra("Content", binding.editTextContent.text.toString())
            returnIntent.putExtra("Name", binding.editTextName.text.toString())
            setResult(200, returnIntent)
            finish()
        }
    }
}