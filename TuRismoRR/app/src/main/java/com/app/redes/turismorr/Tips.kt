package com.app.redes.turismorr

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Matt on 04/02/2019.
 */
class Tips  constructor( ):Parcelable{
    private var nome: String? = null
    private var descricao: String? = null
    private var photo: Int = 0

    constructor(parcel: Parcel) : this() {
        nome = parcel.readString()
        descricao = parcel.readString()
        photo = parcel.readInt()
    }

    fun getNome(): String? {
        return nome
    }
    fun getDescricao(): String? {
        return descricao
    }

    fun getPhoto(): Int? {
        return photo
    }

    fun setPhoto(photo: Int) {
        this.photo = photo
    }

    fun setNome(nome: String) {
        this.nome = nome
    }
    fun setDescricao(descricao: String) {
        this.descricao = descricao
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(descricao)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tips> {
        override fun createFromParcel(parcel: Parcel): Tips {
            return Tips(parcel)
        }

        override fun newArray(size: Int): Array<Tips?> {
            return arrayOfNulls(size)
        }
    }


}