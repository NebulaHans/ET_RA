package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridLayout
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EngineerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EngineerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var gridLayout: GridLayout
    private lateinit var toggleButton: Button
    private val thirdColumnViewIds = listOf(
        R.id.r_id_voltage,
        R.id.r_id_rpm,
        R.id.r_id_current,
        R.id.r_id_faultCode,
        R.id.r_id_cTemp,
        R.id.r_id_eTemp,
        R.id.r_id_tCoef,
        R.id.r_id_gearStatus,
        R.id.r_id_controllerStatus,
        R.id.l_id_voltage,
        R.id.l_id_rpm,
        R.id.l_id_current,
        R.id.l_id_faultCode,
        R.id.l_id_cTemp,
        R.id.l_id_eTemp,
        R.id.l_id_tCoef,
        R.id.l_id_gearStatus,
        R.id.l_id_controllerStatus
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }



    private fun toggleVisibility(){
        val newVisibility = if (thirdColumnVisible()) View.GONE else View.VISIBLE

        for (viewId in thirdColumnViewIds) {
            val childView = view?.findViewById<View>(viewId)
            childView?.visibility = newVisibility
        }

        // Update button text based on the new visibility state
        val buttonText = if (newVisibility == View.VISIBLE) "Hide" else "Show"
        toggleButton.text = buttonText
    }
    private fun thirdColumnVisible(): Boolean {
        // Check the visibility of the first view in the third column
        return view?.findViewById<View>(thirdColumnViewIds.first())?.visibility == View.VISIBLE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_engineer, container, false)
        gridLayout = view.findViewById(R.id.gRight)
        toggleButton = view.findViewById(R.id.showToggle)

        for (viewId in thirdColumnViewIds) {
            val childView = view.findViewById<View>(viewId)
            childView?.visibility = View.GONE
        }
        // Set click listener for the toggle button
        toggleButton.setOnClickListener {
            // Toggle visibility of the text group
            toggleVisibility()
        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EngineerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EngineerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}