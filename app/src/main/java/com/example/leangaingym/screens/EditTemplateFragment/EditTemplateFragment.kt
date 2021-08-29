package com.example.leangaingym.screens.EditTemplateFragment

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leangaingym.R
import com.example.leangaingym.app.ExercisesApp
import com.example.leangaingym.databinding.FragmentEditTemplateFragmentBinding
import com.example.leangaingym.dto.TemplateExerciseUnitDto
import com.example.leangaingym.ext.dbAndDtoTransformer.convertToEntityFieldString
import com.example.leangaingym.ext.dialogExt.showDialogForExerciseResult
import com.example.leangaingym.room.DBInfo
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditTemplateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class EditTemplateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentEditTemplateFragmentBinding? = null
    private var mDataBase: DBInfo = ExercisesApp.mDatabase
    private var mAdapter: ExerciseUnitAdapter = ExerciseUnitAdapter()

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
        binding = FragmentEditTemplateFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recycleViewExerciseUnits?.layoutManager = LinearLayoutManager(context)
        binding?.recycleViewExerciseUnits?.setHasFixedSize(true)
        binding?.recycleViewExerciseUnits?.adapter = mAdapter

        finishTemplateButtonSetEnable(false)

        val exercisesUnits = mutableListOf<TemplateExerciseUnitDto>()

        binding?.floatingButtonAddExerciseUnit?.setOnClickListener {
            val onLeftButtonClick = { it: TemplateExerciseUnitDto ->
                exercisesUnits.add(it)
                mAdapter.repopulateAdapterData(exercisesUnits)
                binding?.tvExercisesListIsEmptyNotification?.visibility = View.GONE
                finishTemplateButtonSetEnable(true)
            }
            activity?.showDialogForExerciseResult(onLeftButtonClick)
        }

        binding?.floatingButtonFinishTemplate?.setOnClickListener {

            val idSize = mDataBase.getTemplatesListInfoDAO().getAllTemplatesInfo().size

            val mTemplateName = if (binding?.editTemplateName?.text.toString().isNotEmpty()) {
                binding?.editTemplateName?.text.toString()
            } else {
                "No name"
            }

            val mDescription = if (binding?.editTemplateDescription?.text.toString().isNotEmpty()) {
                binding?.editTemplateDescription?.text.toString()
            } else {
                "No description"
            }

            val mDate = if (binding?.editTemplateDate?.text.toString().isNotEmpty()) {
                binding?.editTemplateDate?.text.toString()
            } else {
                "No date"
            }

            val exercisesList = mutableListOf<TemplateExerciseUnitDto>()
            val mExercise = TemplateExerciseUnitDto(
                mExerciseName = "Exercise Test Name",
                mNumberOfApproaches = 5,
                mNumberOfRepetitions = 5
            )

            exercisesList.add(mExercise)

            mDataBase.getTemplatesListInfoDAO().add(
                TemplatesDatabaseCommonInfoEntity(
                    id = idSize + 1,
                    templateName = mTemplateName,
                    description = mDescription,
                    date = mDate,
                    exercises = exercisesList.convertToEntityFieldString()
                )
            )
            Navigation.findNavController(view).navigateUp()
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun finishTemplateButtonSetEnable(isEnabled: Boolean) {
        if (isEnabled) {
            binding?.floatingButtonFinishTemplate?.isEnabled = true
            binding?.floatingButtonFinishTemplate?.backgroundTintList = context?.let {
                ContextCompat.getColor(
                    it, R.color.teal_200
                )
            }?.let { ColorStateList.valueOf(it) }
        } else {
            binding?.floatingButtonFinishTemplate?.isEnabled = false
            binding?.floatingButtonFinishTemplate?.backgroundTintList = context?.let {
                ContextCompat.getColor(
                    it, R.color.grey_for_floating_button
                )
            }?.let { ColorStateList.valueOf(it) }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditTemplateFramgent.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditTemplateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}