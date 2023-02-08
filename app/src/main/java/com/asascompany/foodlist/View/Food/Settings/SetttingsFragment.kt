package com.asascompany.foodlist


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.asascompany.foodlist.databinding.FragmentSettingsBinding

class ProfileFragment : Fragment(R.layout.fragment_settings) {

    private var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        val sharedprefs = SharedPrefs(requireContext())
        binding.textView.textSize = sharedprefs.getFontSize()
        binding.apply {
            FontOptions.setOnCheckedChangeListener { radioBtn, checkedId ->
                when (checkedId.toString().last()) {
                    '5' ->{textView.textSize = 80f
                        sharedprefs.saveFontSize("small")}
                    '6' ->{textView.textSize = 50f
                        sharedprefs.saveFontSize("medium")}
                    '7' ->{textView.textSize = 20f
                        sharedprefs.saveFontSize(("large"))}
                }
            }
        }
    }
}