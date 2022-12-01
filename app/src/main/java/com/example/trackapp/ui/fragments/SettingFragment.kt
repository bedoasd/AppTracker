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
import com.example.trackapp.other.TrackingUtilities
import com.example.trackapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_setting.*
import kotlinx.android.synthetic.main.item_run.view.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SettingFragment : Fragment() {

    val args: SettingFragmentArgs by navArgs()
    lateinit var run: Run


    lateinit var binding: FragmentSettingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        run = args.run

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        binding.tvDate.text = dateFormat.format(calendar.time)
        binding.tvTime.text = TrackingUtilities.getFormattedStopWatchTime(run.timeInMillis)
        binding.tvDistance.text =  "${run.distanceInMeters / 1000f}km"
        binding.tvAvgSpeed.text = "${run.avgSpeedInKMH}km/h"

        binding.tvsteps.text = "${run.distanceInMeters/.9f} ${"steps"}"




        Glide.with(this).load(run.img).into(binding.ivRunImage)

    }








}