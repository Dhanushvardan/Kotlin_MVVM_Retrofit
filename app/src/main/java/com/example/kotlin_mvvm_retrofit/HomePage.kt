package com.example.kotlin_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_mvvm_retrofit.databinding.ActivityMainBinding
import com.example.kotlin_mvvm_retrofit.databinding.HomePageBinding

class HomePage:AppCompatActivity() {

    private lateinit var binding:HomePageBinding

    private lateinit var vM : DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = HomePageBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)

        prefs.edit().putBoolean("isLoggedIn", true).apply()

        val g = intent.getStringExtra("user_name")

       binding.recView.layoutManager = LinearLayoutManager(this)




        vM = ViewModelProvider(this)[DataViewModel::class.java]

        vM.d.observe(this){d->
            if(d!= null){

                binding.recView.adapter = Adapter(d)
            }

        }

        vM.getData()




        binding.logoutButton.setOnClickListener{
            prefs.edit().putBoolean("isLoggedIn",false).apply()

            val intent = Intent(this, MainActivity::class.java)


            intent.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)


        }

    }

}