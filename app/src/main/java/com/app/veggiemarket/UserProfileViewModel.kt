package com.app.veggiemarket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

data class UserInfo(val name: String = "", val location: String = "")

class UserProfileViewModel : ViewModel() {
    val emailId: MutableLiveData<String> = MutableLiveData()
    val userName: MutableLiveData<String> = MutableLiveData()
    val userLocation: MutableLiveData<String> = MutableLiveData()

    init {
        getUserData()
    }

    private fun getUserData() {
        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            emailId.value = it.email

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("/users/${it.uid}")

            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userInfo = snapshot.getValue(UserInfo::class.java)
                    userInfo?.let {
                        userName.value = it.name
                        userLocation.value = it.location
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle possible errors
                }
            })
        }
    }
}
