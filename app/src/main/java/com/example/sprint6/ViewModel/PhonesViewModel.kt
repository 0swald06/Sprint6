package com.example.sprint6.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sprint6.Model.Local.Database.PhonesDatabase
import com.example.sprint6.Model.Local.Database.PhonesDetailEntity
import com.example.sprint6.Model.Local.Database.PhonesEntity
import com.example.sprint6.Model.Local.PhonesDao
import com.example.sprint6.Model.PhonesRepository
import kotlinx.coroutines.launch

class PhonesViewModel (application: Application): AndroidViewModel(application){

    private val repository:PhonesRepository

    private val phonesDetailLiveData= MutableLiveData<PhonesDetailEntity>()

    private var idSelected:String="-1"


    init {
        val bd=PhonesDatabase.getDataBase(application)

        val phoneDao=bd.getPhonesDao()
        repository= PhonesRepository(phoneDao)
        viewModelScope.launch {
            repository.fechPhones()
        }
    }
    fun getPhonesList(): LiveData<List<PhonesEntity>> =repository.phoneListLiveData

    fun getPhonesDetail(): LiveData<PhonesDetailEntity> = phonesDetailLiveData

    fun getPhonesDetailByIdFromInternet(id:String)= viewModelScope.launch {

        val phoneDetail=repository.fetchPhonesDetail(id)
        phoneDetail?.let {
            phonesDetailLiveData.postValue(it)
        }


    }


}