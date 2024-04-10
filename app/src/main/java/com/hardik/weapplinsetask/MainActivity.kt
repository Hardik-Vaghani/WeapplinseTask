package com.hardik.weapplinsetask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var spiralAdapter: SpiralAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNumber)
        editText2 = findViewById(R.id.editTextNumber2)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerView)
        spiralAdapter = SpiralAdapter()
        button.setOnClickListener{
            if (!editText.text.isNullOrEmpty() && !editText2.text.isNullOrEmpty()){
                val list = printSpiral(editText.text.toString().toInt(), editText2.text.toString().toInt())
                spiralAdapter.updateData(list)
                setRecyclerView()
            }
        }



//        printSpiral(10,7)
    }

    private fun setRecyclerView() {
        recyclerView.apply {
            adapter = spiralAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, editText2.text.toString().toInt(), RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.HORIZONTAL))
        }

    }
}