package com.example.navigationprojects

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationprojects.databinding.FragmentCalcBinding
import com.example.navigationprojects.databinding.FragmentDadosBinding


class CalcFragment : Fragment() {
    private var _b: FragmentCalcBinding? = null
    private val b get() = _b!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _b = FragmentCalcBinding.inflate(inflater,container, false)
        return b.root
    }


}