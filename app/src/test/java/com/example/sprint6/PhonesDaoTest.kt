package com.example.sprint6

import android.content.Context
import android.os.Build.VERSION_CODES.Q
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sprint6.Model.Local.Database.PhonesDatabase
import com.example.sprint6.Model.Local.Database.PhonesEntity
import com.example.sprint6.Model.Local.PhonesDao
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk=[Q], manifest=Config.NONE)
class PhonesDaoTest {


    private lateinit var phonesDaoTest: PhonesDao
    private lateinit var db:PhonesDatabase

    @Before
    fun setUp(){
        val context=ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,PhonesDatabase::class.java).build()
        phonesDaoTest=db.getPhonesDao()
    }


    @After
    fun shutDown(){

        db.close()
    }

    @Test
    fun insertPhonesList()= runBlocking {
//Given
        val phonesEntity= listOf(

            PhonesEntity("52","prueba1","1000","url"),
            PhonesEntity("53","prueba2","10000","url"),
        )
        //When
        phonesDaoTest.insertAllPhones(phonesEntity)

        val phonesLiveData=phonesDaoTest.getAllPhones()
        val phonesList=phonesLiveData.value?: emptyList()

        //Then
     assertThat(phonesList, not(emptyList()))
        assertThat(phonesList.size,equalTo(2))

    }


}