package com.example.leangaingym.screens.exerciseTuning

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leangaingym.R
import com.example.leangaingym.databinding.FragmentExerciseTuningBinding
import com.example.leangaingym.utils.TEMPLATE_ID
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.stateViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExerciseTuningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExerciseTuningFragment : ScopeFragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentExerciseTuningBinding? = null
    private var mAdapter: TemplatesAdapter = TemplatesAdapter()
    private val mViewModel: ExerciseTuningViewModel by stateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseTuningBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.floatingButtonAddTemplate?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.exerciseTuningFragment_to_editTemplateFramgent)
        }

        binding?.recycleViewTemplates?.layoutManager = LinearLayoutManager(context)
        binding?.recycleViewTemplates?.setHasFixedSize(true)
        binding?.recycleViewTemplates?.adapter = mAdapter

        mAdapter.addListOfItems(mViewModel.getAllTemplatesFromDatabase().toMutableList())

        mAdapter.setItemClick {
            val bundle = Bundle()
            bundle.putInt(TEMPLATE_ID, it.mId)
            Log.e("HZ", "SOME TEMPLATE CLICKED")
            findNavController().navigate(
                R.id.action_exerciseTuningFragment_to_templateInfoFragment, bundle
            )
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment exerciseTuningFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExerciseTuningFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}