package com.asutosh.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.asutosh.retrofit.data.api.Resource
import com.asutosh.retrofit.data.response.PersonalDetailsResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel

@Inject constructor(private val repository: MainRepository):ViewModel() {

    val personalDetailsData : MutableLiveData<Resource<PersonalDetailsResponse>> = MutableLiveData<Resource<PersonalDetailsResponse>>()

    fun getPersonalDetails()  = viewModelScope.launch {

        repository.getPersonalDetailsApi().let {
            if (it.isSuccessful){
                personalDetailsData.postValue(Resource.success(it.body()))
            }else{
                personalDetailsData.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }

    }
}
