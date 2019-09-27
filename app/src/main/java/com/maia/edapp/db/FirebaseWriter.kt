package com.maia.edapp.db


import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.maia.edapp.models.User

class FirebaseWriter {
    private val db = FirebaseFirestore.getInstance()
    private val TAG = "Database"
    fun addUser(user: User) {
        val dbUser = hashMapOf(
            "breakfast" to mutableListOf<String>(),
            "lunch" to mutableListOf<String>(),
            "dinner" to mutableListOf<String>(),
            "sn1" to mutableListOf(),
            "sn2" to mutableListOf(),
            "sn3" to mutableListOf()
        )
        db.collection("users")
            .document(user.email)
            .set(dbUser)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }

    fun addMeal(food: String, user: User, meal: String) {
        val dbUser = db.collection("users").document(user.email)
        dbUser
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val mealList = document.data?.get(meal) as MutableList<String>
                    mealList.add(food)
                    dbUser.update(meal, mealList)
                        .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
                        .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }
}