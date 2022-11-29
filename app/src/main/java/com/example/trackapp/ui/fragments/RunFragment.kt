package com.example.trackapp.ui.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trackapp.R
import com.example.trackapp.adapter.RunAdapter
import com.example.trackapp.databinding.FragmentRunBinding
import com.example.trackapp.db.Run
import com.example.trackapp.db.RunDao
import com.example.trackapp.other.Constants.Companion.REQUEST_CODE_LOCATION_PERMISSION
import com.example.trackapp.other.TrackingUtilities
import com.example.trackapp.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_run.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


@AndroidEntryPoint
class RunFragment : Fragment() ,EasyPermissions.PermissionCallbacks {

    lateinit var binding: FragmentRunBinding




    private  val mainViewModel:MainViewModel by viewModels()
    private lateinit var runAdapter: RunAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        requestPermissions()
        setupRecyclerView()

        mainViewModel.runSortedByDate.observe(viewLifecycleOwner, Observer {
            runAdapter.submitList(it)
        })

        binding.fab.setOnClickListener{
            val action=RunFragmentDirections.actionRunFragmentToTrackFragment()
            findNavController().navigate(action)
        }


        runAdapter.setOnItemClickListener {

            Log.e("pos","${it.avgSpeedInKMH}")
            val action=RunFragmentDirections.actionRunFragmentToSettingFragment2(it)
            findNavController().navigate(action)


            /*val bundle =Bundle().apply {
                putSerializable("article",it)
            }

            findNavController().navigate(
                R.id.action_runFragment_to_settingFragment2
                ,bundle
            )
*/

        }


    }



    private fun setupRecyclerView() = rvRuns.apply {
        runAdapter = RunAdapter()
        adapter=runAdapter
        layoutManager = LinearLayoutManager(requireActivity())
       // ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(this)
    }




    private fun requestPermissions() {
        if (TrackingUtilities.hasLocationPermissions(requireContext())) {
            return
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permission to use this app",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).setThemeResId(R.style.AlertDialogTheme).build().show()
        } else {
            requestPermissions()
        }
    }


}