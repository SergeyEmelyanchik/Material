package ru.geekbrains.material.view.ux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.geekbrains.material.databinding.FragmentUxButtonBinding
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType

class TutorialButtonUXFragment : Fragment() {
    private var _binding: FragmentUxButtonBinding? = null
    private val binding: FragmentUxButtonBinding
        get() = _binding!!

    companion object{
        fun newInstance() = TutorialButtonUXFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GuideView.Builder(requireContext())
            .setTitle("Guide Title Text")
            .setContentText("Guide Description Text\n .....Guide Description Text\n .....Guide Description Text .....")
            .setTargetView(binding.btnBad)
            .setDismissType(DismissType.outside) //optional - default dismissible by TargetView
            .build()
            .show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxButtonBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}