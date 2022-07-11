package com.example.assignment12

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment12.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private var modifyPosition : Int = 0
    private var modifycheck : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val adapter = PostAdapter(emptyList())
        setContentView(view)

        binding.contentBoard.layoutManager = LinearLayoutManager(this)
        binding.contentBoard.adapter = PostAdapter(emptyList())


        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 100) {
                val myData: Intent? = result.data
                val nowTime = Date(System.currentTimeMillis())
                val post = PostData(
                    myData?.getStringExtra("Title").toString(),
                    myData?.getStringExtra("Content").toString(),
                    myData?.getStringExtra("Name").toString(),
                    nowTime
                )
                viewModel.addTask(post)
            }
            else if ((result.resultCode == 200) and modifycheck) {
                val myData: Intent? = result.data
                val nowTime = Date(System.currentTimeMillis())
                val post = PostData(
                    myData?.getStringExtra("Title").toString(),
                    myData?.getStringExtra("Content").toString(),
                    myData?.getStringExtra("Name").toString(),
                    nowTime
                )
                viewModel.modifyTask(post, modifyPosition)
                modifycheck = false
            }
        }

        adapter.setItemClickListener(object : PostAdapter.OnItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                modifycheck = true
                modifyPosition = position
                val intent = Intent(this@MainActivity, ModifyPostActivity::class.java)
                resultLauncher.launch(intent)
            }

            override fun onLongClick(v: View, position: Int) {
                viewModel.deleteTask(position)
            }
        })

        viewModel.postLiveData.observe(this) {
            (binding.contentBoard.adapter as PostAdapter).setData(it)
        }

        binding.addContentButton.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

}

