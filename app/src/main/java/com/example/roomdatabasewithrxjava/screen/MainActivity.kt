package com.example.roomdatabasewithrxjava.screen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabasewithrxjava.R
import com.example.roomdatabasewithrxjava.data.source.UserRepository
import com.example.roomdatabasewithrxjava.data.source.local.UserLocalDataSource
import com.example.roomdatabasewithrxjava.data.source.local.persistence.UserDatabase
import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userRepository =
            UserRepository.getInstance(UserLocalDataSource.getInstance(UserDatabase.getInstance(applicationContext).userDao()))
        buttonAddUser.setOnClickListener(this)
        buttonGetUser.setOnClickListener(this)
        buttonDeleteUser.setOnClickListener(this)
    }

    fun inserUser() {
        val user = User(1, "a", "a@gmail.com", "2000", Calendar.getInstance().time)
        userRepository.insertUser(user)
        Log.d("DATA", userRepository.getUserById(1)?.date.toString())
    }

    fun insertPet() {
        val pet = Pet(1, "cat", 1)
        userRepository.insertPet(pet)
        Log.d("DATA_PET", userRepository.getPetsForUser(1).toString())
    }

    fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    fun updateUser(vararg user: User) {
        userRepository.updateUser(*user)
    }

    fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonAddUser -> {
                inserUser()
                insertPet()
            }
            R.id.buttonGetUser -> {
                if (getUserById(1) != null) {
                    textViewUserName.text = getUserById(1)?.name
                }
            }
            R.id.buttonDeleteUser -> deleteUser(1)

        }
    }
}
