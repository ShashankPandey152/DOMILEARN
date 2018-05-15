package com.example.hp.domilearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val ref = FirebaseDatabase.getInstance("https://domilearn-73d87.firebaseio.com/").getReference("names")
//
//        ref.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(p0: DatabaseError?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDataChange(p0: DataSnapshot?) {
//                if(p0!!.exists()){
//                    for(h in p0.children) {
//                        val value =  h.getValue()
//                        textView.text = value.toString()
//                    }
//                }
//            }
//
//        })

        submitBtn.setOnClickListener {
            val ref = FirebaseDatabase.getInstance("https://domilearn-73d87.firebaseio.com/").getReference("names")
            val id = ref.push().key
            ref.child(id).setValue("shashank").addOnCompleteListener{
                Toast.makeText(this,"Succesfully",Toast.LENGTH_SHORT).show()
            }
            ref.addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if(p0!!.exists()){
                        for(h in p0.children) {
                            val value =  h.getValue()
                            textView.text = value.toString()
                        }
                    }
                }

            })
        }
    }
}
