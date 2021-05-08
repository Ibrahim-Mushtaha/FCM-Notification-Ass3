package com.ix.ibrahim7.ps.notification_fcm.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ix.ibrahim7.ps.notification_fcm.R
import com.ix.ibrahim7.ps.notification_fcm.databinding.FragmentSignUpBinding
import com.ix.ibrahim7.ps.notification_fcm.other.setToolbarView
import com.ix.ibrahim7.ps.notification_fcm.ui.dialog.LoadingDialog
import com.ix.ibrahim7.ps.notification_fcm.ui.viewmodel.SignUpViewModel
import com.ix.ibrahim7.ps.notification_fcm.util.Resource


class SignUpFragment : Fragment() {

    private val mBinging by lazy{
        FragmentSignUpBinding.inflate(layoutInflater)
    }

    val viewModel : SignUpViewModel by lazy {
        ViewModelProvider(this)[SignUpViewModel::class.java]
    }

    lateinit var dialog: LoadingDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = mBinging.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog = LoadingDialog()

        requireActivity().setToolbarView(
            mBinging.toolbarLayout,
            getString(R.string.sign_up),
            false
        ) {
            findNavController().navigateUp()
        }
        signUp()

        viewModel.dataSignUpViewModel.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is Resource.Loading->{
                    dialog.show(childFragmentManager,"")
                }
                is Resource.Error->{
                    if (dialog.isAdded)
                        dialog.dismiss()
                    Toast.makeText(requireContext(),response.message,Toast.LENGTH_SHORT).show()
                }
                is Resource.Success->{
                    if (dialog.isAdded)
                        dialog.dismiss()
                    Toast.makeText(requireContext(),"Done",Toast.LENGTH_SHORT).show()
                }
            }
        })


        }

    fun signUp(){
        mBinging.btnSignUp.setOnClickListener {
            when {
                TextUtils.isEmpty(mBinging.txtUsername.text.toString()) -> {
                    mBinging.txtUsername.requestFocus()
                    mBinging.txtUsername.error = getString(R.string.require_field)
                    return@setOnClickListener
                }
                TextUtils.isEmpty(mBinging.txtEmail.text.toString()) -> {
                    mBinging.txtEmail.requestFocus()
                    mBinging.txtEmail.error = getString(R.string.require_field)
                    return@setOnClickListener
                }
                TextUtils.isEmpty(mBinging.txtPassword.text.toString()) -> {
                    mBinging.txtPassword.requestFocus()
                    mBinging.txtPassword.error = getString(R.string.require_field)
                    return@setOnClickListener
                }
                else -> {
                        viewModel.SignUp(mBinging.txtEmail.text.toString(),mBinging.txtPassword.text.toString())
                }
            }
        }
    }

}