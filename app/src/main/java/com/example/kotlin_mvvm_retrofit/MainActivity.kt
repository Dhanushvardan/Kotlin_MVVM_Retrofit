package com.example.kotlin_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

            if(binding.etusername.text.toString().length != 0){
                if(prefs.contains(name)){
                    val intent = Intent(this,HomePage::class.java)
                    if(binding.etpass.text.toString() == prefs.getString(name,"") && binding.etusername.text.toString().length != 0)
                    {
                        intent.putExtra("user_name",name)

                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Invalid Password",Toast.LENGTH_SHORT).show()
                    }


                }
                else{
                    Toast.makeText(this,"Register To LogIn",Toast.LENGTH_SHORT).show()
                    val intnt = Intent(this,SignUp::class.java)
                    startActivity(intnt)
                }
            }
            else{
                Toast.makeText(this,"Invalid credentials",Toast.LENGTH_SHORT).show()
            }








        }
    }
}