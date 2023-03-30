package com.example.moviesapp.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.databinding.ActivityLoginFragmentBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {

    lateinit var binding: ActivityLoginFragmentBinding
    private var mAuth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityLoginFragmentBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        binding.signup.setOnClickListener {
            val action=LoginFragmentDirections.actionLoginFragmentToSignupFragment()
           findNavController().navigate(action)
        }
        binding.signButton.setOnClickListener {
            logIn()
        }
    }



    private fun logIn(){
        val Email = binding.emailLogin.text.toString()
        val Pass = binding.password.text.toString()
        if (Email.isNotEmpty() && Pass.isNotEmpty()) {
            mAuth?.signInWithEmailAndPassword(Email, Pass)
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {

                        verifyEmail()
                    } else {
                        Toast.makeText(
                            activity,
                            it.exception.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
        }else {
            Toast.makeText(activity?.application ?:context,"Please Complete Your information",Toast.LENGTH_LONG).show()
        }

    }

    private fun verifyEmail() {
        val user= mAuth?.currentUser
        if (user!!.isEmailVerified ){
            val intent=Intent(activity?.application ?:context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        else{
            Toast.makeText(activity?.application ?:context,"Please Verify Your Email",Toast.LENGTH_LONG).show()
        }
    }

}