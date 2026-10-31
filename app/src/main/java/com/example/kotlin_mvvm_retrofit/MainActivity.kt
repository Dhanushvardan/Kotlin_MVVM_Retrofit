package com.example.kotlin_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_mvvm_retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)




        val isLoggedIn = prefs.getBoolean("isLoggedIn",false)




        if(isLoggedIn){
            val name = binding.etusername.text.toString()

            val intent = Intent(this, HomePage::class.java)

            intent.putExtra("user_name", name)


            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }



        binding.loginButton.setOnClickListener{

            val name = binding.etusername.text.toString()

            val intent = Intent(this,HomePage::class.java)


            intent.putExtra("user_name",name)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)





        }
    }
}