package com.example.paypal.view.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.paypal.R
import com.example.paypal.databinding.FragmentScreenBinding
import com.example.paypal.viewmodel.InfoViewModel
import com.squareup.picasso.Picasso

class ScreenFragment : Fragment(R.layout.fragment_screen) {

    private lateinit var binding: FragmentScreenBinding
    private val viewModel: InfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScreenBinding.bind(view)
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        if (isConnected)
            setup()
        else
            Toast.makeText(context, "No hay internet", Toast.LENGTH_SHORT).show()
    }

    private fun setup() {

        viewModel.trappistInfo.observe(viewLifecycleOwner, Observer { trappistInfo ->
            trappistInfo?.let {
                binding.textViewCopyright.text = it.copyright
                binding.textViewDate.text = it.date
                binding.textViewTitle.text = it.title
                binding.textViewExplanation.text = it.explanation
                Picasso.get().load(it.hdurl).placeholder(R.drawable.error).error(R.drawable.error).into(binding.imageView)

            }
        })

        viewModel.fetchTrappistInfo()

    }
}