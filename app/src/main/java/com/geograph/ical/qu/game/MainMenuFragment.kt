package com.geograph.ical.qu.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.geograph.ical.qu.R
import com.geograph.ical.qu.databinding.FragmentMainMenuBinding

import java.io.File
import java.io.FileInputStream
import java.io.FileWriter

import kotlin.properties.Delegates


class MainMenuFragment : Fragment() {
    private var binding by Delegates.notNull<FragmentMainMenuBinding>()
    var musicOn:Boolean = true
    var soundsOn:Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.newgame1.setOnClickListener {
            requireView().findNavController()
                .navigate(R.id.action_mainMenuFragment_to_gameFragment, bundleOf("id" to 1, "musicOn" to musicOn,
                    "soundsOn" to soundsOn))

        }

        binding.newgame2.setOnClickListener {
           requireActivity().finishAffinity()
        }





    }






}
