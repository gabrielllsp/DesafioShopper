package com.gabriel.desafioshopper.util


import androidx.fragment.app.Fragment
import com.gabriel.desafioshopper.R
import com.gabriel.desafioshopper.databinding.LayoutBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import retrofit2.HttpException


fun Fragment.showButtonSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String?,
    onClick: () -> Unit = {}
) {
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val bottomSheetBinding: LayoutBottomSheetBinding =
        LayoutBottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetBinding.textTitle.text = getString(titleDialog ?: R.string.text_title_bottom_sheet)
    bottomSheetBinding.textMessage.text = message
    bottomSheetBinding.btnOk.text = getString(titleDialog ?: R.string.text_button_bottom_sheet)

    bottomSheetBinding.btnOk.setOnClickListener {
        bottomSheetDialog.dismiss()
        onClick()
    }

    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()
}

inline fun <reified T> HttpException.getErrorResponse(): T? {
    return try {
        Gson().fromJson(response()?.errorBody()?.string(), T::class.java)
    } catch (e: Exception) {
        null
    }
}