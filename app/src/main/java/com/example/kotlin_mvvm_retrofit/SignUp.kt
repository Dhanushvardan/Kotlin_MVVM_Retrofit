package com.example.kotlin_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_mvvm_retrofit.databinding.SignupPageBinding

class SignUp:AppCompatActivity() {


    private lateinit var binding:SignupPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pref = getSharedPreferences("prefs", MODE_PRIVATE)




        binding.sigupButton.setOnClickListener{

            if(pref.contains(binding.signupnameet.text.toString())){
                Toast.makeText(this,"user already exists",Toast.LENGTH_SHORT).show()
            }
            else{
                pref.edit().putString(binding.signupnameet.text.toString(),binding.signuppasset.text.toString()).apply()
                Toast.makeText(this,"User register successfull", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }





        }

    }
}