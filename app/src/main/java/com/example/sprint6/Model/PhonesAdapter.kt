package com.example.sprint6.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprint6.Model.Local.Database.PhonesEntity
import com.example.sprint6.databinding.ItemPhoneBinding

class PhonesAdapter:RecyclerView.Adapter<PhonesAdapter.PhonesVH>() {


    private var listPhone= listOf<PhonesEntity>()
    private val selectedPhone= MutableLiveData<PhonesEntity>()





    fun update(list:List<PhonesEntity>){

        listPhone=list
        notifyDataSetChanged()
    }

    fun selectedPhone():LiveData<PhonesEntity> = selectedPhone

    inner class  PhonesVH(private val mBinding: ItemPhoneBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(phone:PhonesEntity){
            Glide.with(mBinding.itemImagen).load(phone.image).centerCrop()
                .into(mBinding.itemImagen)
            mBinding.itemNombre.text=phone.name
            mBinding.itemPrecio.text="Precio: "+phone.price
            itemView.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            selectedPhone.value=listPhone[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesVH {
        return  PhonesVH(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: PhonesVH, position: Int) {
        val phone = listPhone[position]
        holder.bind(phone)
    }
    override fun getItemCount()= listPhone.size


}