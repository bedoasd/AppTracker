package com.example.trackapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.trackapp.R
import com.example.trackapp.databinding.FragmentSettingBinding
import com.example.trackapp.db.Run
import com.example.trackapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {

    val args: SettingFragmentArgs by navArgs()
    lateinit var run: Run


    lateinit var  binding:FragmentSettingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        run=args.run

        binding.tvDate.text = run.timestamp.toString()
        binding.tvTime.text = run.timeInMillis.toString()
        binding.tvDate.text = run.distanceInMeters.toString()
        binding.tvAvgSpeed.text = run.avgSpeedInKMH.toString()

        Glide.with(this).load(run.img).into(binding.ivRunImage)



    }



}