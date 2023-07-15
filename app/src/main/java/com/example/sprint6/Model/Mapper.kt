package com.example.sprint6.Model

import com.example.sprint6.Model.Local.Database.PhonesDetailEntity
import com.example.sprint6.Model.Local.Database.PhonesEntity
import com.example.sprint6.Model.Remote.FromInternet.Phones
import com.example.sprint6.Model.Remote.FromInternet.PhonesDetail

fun fromInternetToPhonesEntity(phonesList:List<Phones>):List<PhonesEntity>{

    return phonesList.map {

        PhonesEntity(
            id=it.id,
            name=it.name,
            price=it.price,
            image=it.image,

            )
    }

}
fun fromInternetToPhonesDetailEntity(phones:PhonesDetail):PhonesDetailEntity{

    return  PhonesDetailEntity(
        id=phones.id,
        name=phones.name,
        price=phones.price,
        image=phones.image,
        description = phones.description,
        lastPrice = phones.lastPrice,
        credit = phones.credit
    )
}