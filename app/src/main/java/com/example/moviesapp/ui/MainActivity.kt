package com.example.moviesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.actors.ui.ActorsFragment
import com.example.moviesapp.ui.home.ui.HomeFragment

import com.example.moviesapp.ui.profile.ProfileFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
//    private val fragmentHome= HomeFragment()
//    private val fragmentProfile=ProfileFragment()
//    private val fragmentActors= ActorsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        val navController =findNavController(R.id.fragment_container)
        binding.nav.setupWithNavController(navController)




    }



//    private fun addNavigationListner() {
//        binding.nav.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.HomePage -> {
//                    showFragment(fragmentHome)
//                    true
//                }
//                R.id.Profile -> {
//                    showFragment(fragmentProfile)
//                    true
//                }
//                R.id.Actors -> {
//                    showFragment(fragmentActors)
//                    true
//                }
//                else ->false
//            }
//        }
//    }
//
//
//    private fun showFragment(fragment : Fragment) {
//        val transaction=supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragment_container,fragment)
//        transaction.commit()
//    }
//
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.log_out,menu)
        return true
    }
//
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val id=item.itemId
        if(id== R.id.logOut){
            FirebaseAuth.getInstance().signOut()
            finish()
            val intent=Intent(this,User_Activity::class.java)
            startActivity(intent)
        }
        return true
    }

}