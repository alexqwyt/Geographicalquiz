package com.geograph.ical.quiz.game


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.geograph.ical.quiz.R
import com.geograph.ical.quiz.databinding.FragmentEndBinding

import kotlin.properties.Delegates


class EndFragment : Fragment() {

    var c = 0

    private var binding by Delegates.notNull<FragmentEndBinding>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEndBinding.inflate(inflater, container, false)
        return binding.root

    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        c = arguments?.getInt("count")!!

        binding.tvText.text = "Correct answers: $c "

        binding.tvEnd.setOnClickListener {


            requireView().findNavController().navigate(R.id.action_endFragment_to_mainMenuFragment)
        }


    }


}