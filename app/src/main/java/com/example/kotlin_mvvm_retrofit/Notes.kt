package com.example.kotlin_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_mvvm_retrofit.databinding.NotesBinding

class Notes:AppCompatActivity() {

    private lateinit var binding:NotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notesNavBar.setOnItemSelectedListener{
                item->
            when(item.itemId){
                R.id.home-> {
                    val intt = Intent(this,HomePage::class.java)
                    startActivity(intt)
                    true
                }
                R.id.profile->{
                    val intent = Intent(this,profiles::class.java)
                    startActivity(intent)
                    true
                }
                R.id.notes->{
                    val intnt = Intent(this,Notes::class.java)
                    startActivity(intnt)
                    true
                }
                else -> false
            }

        }

    }
}