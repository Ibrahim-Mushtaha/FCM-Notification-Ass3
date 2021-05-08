package com.ix.ibrahim7.ps.notification_fcm.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ix.ibrahim7.ps.notification_fcm.util.Resource


class SignUpViewModel : ViewModel() {

    var dataSignUpViewModel = MutableLiveData<Resource<Boolean>>()

    fun SignUp(email:String,password:String){
        dataSignUpViewModel.postValue(Resource.Loading())
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            dataSignUpViewModel.postValue(Resource.Success(true))
        }.addOnFailureListener {error->
            dataSignUpViewModel.postValue(Resource.Error(error.message.toString(),false))
        }
    }
}