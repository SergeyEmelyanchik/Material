package ru.geekbrains.material.view.layout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.geekbrains.material.databinding.FragmentConstraintBinding

class ConstraintFragment : Fragment() {


    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.buttons.visibility= View.GONE
    }


    companion object {
        @JvmStatic
        fun newInstance() = ConstraintFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}