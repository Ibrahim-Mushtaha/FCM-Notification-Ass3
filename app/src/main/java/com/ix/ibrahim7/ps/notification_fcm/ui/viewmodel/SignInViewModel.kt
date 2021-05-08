package com.ix.ibrahim7.ps.notification_fcm.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ix.ibrahim7.ps.notification_fcm.util.Resource


class SignInViewModel : ViewModel() {

    var dataSignInViewModel = MutableLiveData<Resource<Boolean>>()

    fun signIn(email:String,password:String){
        dataSignInViewModel.postValue(Resource.Loading())
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnSuccessListener {
            dataSignInViewModel.postValue(Resource.Success(true))
        }.addOnFailureListener {error ->
            dataSignInViewModel.postValue(Resource.Error(error.message.toString(),false))
        }
    }
}