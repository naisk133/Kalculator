package com.sk.nai.kalculator

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by naisk133 on 22/12/2559.
 */
class Formula(val name: String, val params: List<String>, val formula: String) :Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Formula> = object : Parcelable.Creator<Formula> {
            override fun createFromParcel(source: Parcel): Formula = Formula(source)
            override fun newArray(size: Int): Array<Formula?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.createStringArrayList(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeStringList(params)
        dest?.writeString(formula)
    }
}