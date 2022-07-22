package com.example.navigationprojects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.random.Random
import com.example.navigationprojects.databinding.FragmentDadosBinding
import kotlin.random.nextInt

class DadosFragment : Fragment() {
    private var _b: FragmentDadosBinding? = null
    private val b get() = _b!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentDadosBinding.inflate(inflater, container, false)

        b.btnRoll.setOnClickListener {
            val n1 = Random.nextInt(1..7)
            val n2 = Random.nextInt(1..7)
            b.imvDado1.setImageResource(when(n1){
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6 })


            b.imvDado2.setImageResource(when(n2){
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6 })
            if (n1>n2){
                b.tvResult.text = getText(R.string.winner1)
            }else if (n1<n2){
                b.tvResult.text = getText(R.string.winner2)
            }else b.tvResult.text = "Empate"
        }
        return b.root

    }
//    fun roll(num:Int) {
//    val imgResource = when(num){
//        1 -> R.drawable.dice1
//        2 -> R.drawable.dice2
//        3 -> R.drawable.dice3
//        4 -> R.drawable.dice4
//        5 -> R.drawable.dice5
//        else -> R.drawable.dice6 }
//    }
}
