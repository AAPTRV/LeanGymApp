package com.example.leangaingym.ext.dialogExt

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.FrameLayout
import com.example.leangaingym.R

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
//    leftButtonTextId: Int,
//    leftClickListener: View.OnClickListener?,
//    rightButtonTextId: Int,
//    rightClickListener: View.OnClickListener?
) : Dialog{
    val (dialog, contentView) = initExerciseDialogTwoButtonsContent()

    val btnLeft: Button = contentView.findViewById(R.id.dialogLeftButton)
    btnLeft.setOnClickListener { dialog.dismiss() }
    val btnRight: Button = contentView.findViewById(R.id.dialogRightButton)
    btnRight.setOnClickListener { dialog.dismiss() }

    setContentView(dialog, contentView)
    if(!this.isFinishing){
        dialog.show()
    }
    return dialog
}