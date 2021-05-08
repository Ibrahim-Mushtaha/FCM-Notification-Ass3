package com.ix.ibrahim7.ps.notification_fcm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ix.ibrahim7.ps.notification_fcm.R
import com.ix.ibrahim7.ps.notification_fcm.databinding.FragmentSignInBinding
import com.ix.ibrahim7.ps.notification_fcm.databinding.FragmentSignUpBinding
import com.ix.ibrahim7.ps.notification_fcm.other.setToolbarView


class SignUpFragment : Fragment() {

    private val mBinging by lazy{
        FragmentSignUpBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = mBinging.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().setToolbarView(
            mBinging.toolbarLayout,
            getString(R.string.sign_up),
            false
        ) {
            findNavController().navigateUp()
        }


        }

}