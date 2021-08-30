package com.example.leangaingym.ext.dialogExt

import android.app.Activity
import android.app.Dialog
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.leangaingym.R
import com.example.leangaingym.dto.TemplateExerciseUnitDto

val DIALOG_WIDTH_DELTA_7: Float = 0.95F

private fun createDialog(activity: Activity): Dialog {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.window?.let {
        it.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    return dialog
}

private fun Activity.initExerciseDialogTwoButtonsContent(): Pair<Dialog, View> {
    val dialog = createDialog(this)
    dialog.setCanceledOnTouchOutside(false)
    val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_add_exercise, null)
    return Pair(dialog, contentView)
}

private fun setContentView(dialog: Dialog, contentView: View) {
    dialog.setContentView(contentView)
    val window = dialog.window
    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    val resources = dialog.context.resources
    val params = contentView.layoutParams as FrameLayout.LayoutParams
    params.width = ((resources.displayMetrics.widthPixels * DIALOG_WIDTH_DELTA_7).toInt())
    contentView.layoutParams = params
}

fun Activity.showDialogForExerciseResult(
    leftOnClickEvent: (TemplateExerciseUnitDto) -> Unit,
): Dialog {
    val (dialog, contentView) = initExerciseDialogTwoButtonsContent()

    val mEtExerciseName: EditText = contentView.findViewById(R.id.dialogEtExerciseName)
    mEtExerciseName.imeOptions = EditorInfo.IME_ACTION_DONE
    mEtExerciseName.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // Hide Keyboard
            val inputMethodManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(contentView.windowToken, 0)
        }
        false
    }

    val mTvApproachesValue: TextView = contentView.findViewById(R.id.dialogApproachesValue)
    val mBtnApproachesIncrease: Button =
        contentView.findViewById(R.id.dialogIncreaseApproachesButton)
    val mBtnApproachesDecrease: Button =
        contentView.findViewById(R.id.dialogDecreaseApproachesButton)

    val mTvRepetitionsValue: TextView = contentView.findViewById(R.id.dialogRepetitionsValue)
    val mBtnRepetitionsIncrease: Button =
        contentView.findViewById(R.id.dialogIncreaseRepetitionsButton)
    val mBtnRepetitionsDecrease: Button =
        contentView.findViewById(R.id.dialogDecreaseRepetitionsButton)

    mBtnApproachesIncrease.setOnClickListener {
        var value = mTvApproachesValue.text.toString().toInt()
        value++
        mTvApproachesValue.text = value.toString()
    }
    mBtnApproachesDecrease.setOnClickListener {
        var value = mTvApproachesValue.text.toString().toInt()
        if (value > 1) {
            value--
        }
        mTvApproachesValue.text = value.toString()
    }

    mBtnRepetitionsIncrease.setOnClickListener {
        var value = mTvRepetitionsValue.text.toString().toInt()
        value++
        mTvRepetitionsValue.text = value.toString()
    }
    mBtnRepetitionsDecrease.setOnClickListener {
        var value = mTvRepetitionsValue.text.toString().toInt()
        if (value > 1) {
            value--
        }
        mTvRepetitionsValue.text = value.toString()
    }

    val btnLeft: Button = contentView.findViewById(R.id.dialogLeftButton)
    btnLeft.setOnClickListener {
        if(mEtExerciseName.text.isEmpty()){
            Toast.makeText(this, "Exercise name is empty", Toast.LENGTH_SHORT).show()
            mEtExerciseName.requestFocus()
            // TODO: 29.08.2021 SHOW KEY BOARD!
        } else {
            leftOnClickEvent.invoke(
                TemplateExerciseUnitDto(
                    mExerciseName = mEtExerciseName.text.toString(),
                    mNumberOfApproaches = mTvApproachesValue.text.toString().toInt(),
                    mNumberOfRepetitions = mTvRepetitionsValue.text.toString().toInt()
                )
            )
            dialog.dismiss()
        }
    }

    val btnRight: Button = contentView.findViewById(R.id.dialogRightButton)
    btnRight.setOnClickListener { dialog.dismiss() }

    setContentView(dialog, contentView)
    if (!this.isFinishing) {
        dialog.show()
    }
    return dialog
}