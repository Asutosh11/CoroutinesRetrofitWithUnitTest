package com.asutosh.retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.asutosh.retrofit.data.api.Resource
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fireApiAndGetData()
    }

    @SuppressLint("SetTextI18n")
    fun fireApiAndGetData(){

        viewModel.getPersonalDetails()

        viewModel.personalDetailsData.observe(this, Observer {
            when(it.status){
                Resource.Status.SUCCESS -> {

                    it.data.let {
                        tv_show_data.text =
                                    "Name: " + it?.name + "\n" +
                                    "Current City: " + it?.currentCity + "\n" +
                                    "Email: " + it?.email + "\n" +
                                    "Trained At: " + it?.trainedAt + "\n" +
                                    "Skills: " + it?.skills + "\n"
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(applicationContext,it.message, LENGTH_LONG).show()
                }
            }
        })
    }
}