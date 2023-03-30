package com.example.moviesapp.ui.sign_up

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviesapp.R
import com.example.moviesapp.databinding.RegisterFragmentBinding
import com.example.moviesapp.ui.login.LoginFragment
import com.google.firebase.auth.FirebaseAuth


class SignupFragment : Fragment() {
    lateinit var binding: RegisterFragmentBinding
    var mAuth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()

        mAuth = FirebaseAuth.getInstance()

        binding.signButton.setOnClickListener {
            signUp()
        }
        binding.Signin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }


    private fun signUp(){
        val Email = binding.emailRegister.text.toString()
        val Pass = binding.passwordRegister.text.toString()
        if (Email.isNotEmpty() && Pass.isNotEmpty()) {
            binding.progressBar.visibility=ProgressBar.VISIBLE
            mAuth?.createUserWithEmailAndPassword(Email, Pass)
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        sendEmailVerification()
                        binding.progressBar.visibility=ProgressBar.GONE
                        val intent=Intent(activity?.application ?:context,LoginFragment::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            activity?.application ?:context,
                            it.exception.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                        binding.progressBar.visibility=ProgressBar.GONE
                    }
                }
        } else {
            Toast.makeText(activity?.application ?:context,"Please Complete Your information",Toast.LENGTH_LONG).show()
        }
    }

    private fun sendEmailVerification() {
        val user= mAuth?.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(activity?.application ?:context, "Email Success Go To Verify Your Email", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                Toast.makeText(activity?.application ?:context,"Please Complete Your information",Toast.LENGTH_LONG).show()
            }
        }
    }
}