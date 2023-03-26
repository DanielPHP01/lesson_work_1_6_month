package com.example.lesson_work_1_6_month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.lesson_work_1_6_month.databinding.ActivityMainBinding
import java.util.Random

/*Первоначально добавляем в массив 5 рандомных url картинок.
 В xml вы добавляете ImageView, EditText, Button, RandomButton
 При ввводе и нажатии кнопки submit в массив добавляете урл картинки
 при нажатии на рандомБаттон вы рандомно через глайд выводите картинку*/


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var links = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillList()
        initListener()
    }

    private fun initListener() {
        binding.btnSubmit.setOnClickListener {
            links.add(binding.etName.text.toString())
            binding.etName.text.clear()
            Log.i("ololo", "initListener: ${links.last()}")
        }
        binding.btnRandom.setOnClickListener {
            val url = links.random()
            binding.image.loadImage(url)
            Log.w("ololo", "initListener: $url")
        }
    }

    private fun fillList() {
        links.add("https://media.istockphoto.com/id/1463923877/photo/asian-chinese-tourist-camel-caravan-going-through-the-sahara-desert-in-morocco-at-sunset.jpg?b=1&s=170667a&w=0&k=20&c=Xvseanl4CtxDp1IAOGmrqImeYU-WK4bceBJau5X4HE4=")
        links.add("https://images.unsplash.com/photo-1598124146163-36819847286d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80")
        links.add("https://images.unsplash.com/photo-1618417873527-eaf3a1d25c23?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGpwZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60")
        links.add("https://images.unsplash.com/photo-1640681858035-5e62f72d90a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGpwZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60")
        links.add("https://images.unsplash.com/photo-1640033809641-b44037128681?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fGpwZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60")
    }

    fun ImageView.loadImage(link: String) {
        Glide.with(this@MainActivity).load(link).into(this)
    }
}
