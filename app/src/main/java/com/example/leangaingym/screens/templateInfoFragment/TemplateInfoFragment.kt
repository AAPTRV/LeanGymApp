package com.example.leangaingym.screens.templateInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leangaingym.R
import com.example.leangaingym.databinding.FragmentTemplateInfoBinding
import com.example.leangaingym.utils.TEMPLATE_ID
import org.koin.androidx.scope.ScopeFragment
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TemplateInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TemplateInfoFragment : ScopeFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentTemplateInfoBinding? = null
    private var mAdapter: TemplateInfoExerciseUnitAdapter = TemplateInfoExerciseUnitAdapter()
    private var mTemplateId by Delegates.notNull<Int>()
//    private var mViewModel = TemplateViewModel(SavedStateHandle(), mDatabaseExercisesCommonInfoRepository = Data)

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
        // Inflate the layout for this fragment
        binding = FragmentTemplateInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recycleViewTemplateInfo?.layoutManager = LinearLayoutManager(context)
        binding?.recycleViewTemplateInfo?.setHasFixedSize(true)
        binding?.recycleViewTemplateInfo?.adapter = mAdapter

        mAdapter.setItemClick {
            val bundle = Bundle()
            bundle.putString(TEMPLATE_ID, it.mId.toString())
            findNavController().navigate(
                R.id.action_exerciseTuningFragment_to_templateInfoFragment, bundle
            )
        }

//        mAdapter.repopulateAdapterData()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TemplateInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TemplateInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}