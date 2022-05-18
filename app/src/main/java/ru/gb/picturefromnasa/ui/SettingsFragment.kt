package com.example.materialapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import ru.gb.picturefromnasa.R
import ru.gb.picturefromnasa.databinding.FragmentSettingsBinding

const val THEME = "THEME"

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGreenTheme.setOnClickListener {

            val editor = activity?.getPreferences(Context.MODE_PRIVATE)?.edit()
            editor?.putInt(THEME, R.style.AppTheme_GreenTheme)
            editor?.apply()

            recreate(requireActivity())

        }

        binding.btnRedTheme.setOnClickListener {

            val editor = activity?.getPreferences(Context.MODE_PRIVATE)?.edit()
            editor?.putInt(THEME, R.style.AppTheme_RedTheme)
            editor?.apply()

            recreate(requireActivity())
        }
    }
}