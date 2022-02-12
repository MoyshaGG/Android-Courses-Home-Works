package com.mysliukserhii.p1112.ui.detailed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mysliukserhii.p1112.Magnitude
import com.mysliukserhii.p1112.databinding.FragmentDetailedBinding
import com.mysliukserhii.p1112.model.Feature

private var KEY_TIME = "param1"
private var KEY_LOCATION = "param2"
private var KEY_VALUE = "param3"

class DetailedFragment : Fragment() {
    private var time: String? = null
    private var location: String? = null
    private var intense: String? = null
    private var quakeValue: Double = 0.0
    private var _binding: FragmentDetailedBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentDetailedBinding.inflate(layoutInflater)
        arguments?.let {
            time = it.getString(KEY_TIME)
            location = it.getString(KEY_LOCATION)
            quakeValue = it.getDouble(KEY_VALUE)
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedBinding.inflate(inflater, container, false)
        val timeTextView: TextView = binding.dtimeTextView
        val locationTextView: TextView = binding.dlocationTextView
        val quakeValueTextView: TextView = binding.dquakeValueTextView
        val intenseTextView: TextView = binding.dintenseTextView
        val recTextView: TextView = binding.recTextView
        val lineView: View = binding.lineView
        val rec1ImageView: ImageView = binding.rec1ImageView
        val rec2ImageView: ImageView = binding.rec2ImageView
        //якщо магнітуда землетруса менше 4.5 ховаємо рекомендації
        if (quakeValue < 4.5) {
            recTextView.visibility = 0x00000004
            lineView.visibility = 0x00000004
            rec1ImageView.visibility = 0x00000004
            rec2ImageView.visibility = 0x00000004
        }
        val dvo = initMagnitude(quakeValue)
        intenseTextView.setText(dvo.title)
        intenseTextView.setBackgroundResource(dvo.color)
        timeTextView.setText(time)
        locationTextView.setText(location)
        quakeValueTextView.setText(String.format("%.1f", quakeValue))
        val view = binding.root
        return view
    }

    private fun initMagnitude(magnitude: Double): Magnitude {
        return when (magnitude) {
            in 1.0..1.99 -> Magnitude.VERY_LOW
            in 2.0..2.99 -> Magnitude.WEAK
            in 3.0..4.49 -> Magnitude.MEDIUM
            in 4.5..5.99 -> Magnitude.STRONG
            else -> Magnitude.VERY_STRONG
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Feature) =
            DetailedFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_TIME, param1.properties.time.substring(0, 10))
                    putString(KEY_LOCATION, param1.properties.locality)
                    putDouble(KEY_VALUE, param1.properties.magnitude)
                }
            }
    }
}