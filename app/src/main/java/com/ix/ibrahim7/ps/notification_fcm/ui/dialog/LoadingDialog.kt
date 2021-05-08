package com.ix.ibrahim7.ps.notification_fcm.ui.dialog


import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.ix.ibrahim7.ps.notification_fcm.databinding.DialogLoadingBinding

class LoadingDialog : DialogFragment(){

    private lateinit var mBinding: DialogLoadingBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = DialogLoadingBinding.inflate(inflater, container, false).apply {
            executePendingBindings()
        }
        dialog!!.setCancelable(false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }







}