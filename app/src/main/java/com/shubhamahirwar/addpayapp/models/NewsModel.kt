package com.shubhamahirwar.addpayapp.models


import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsModel(
    @SerialName("author")
    val author: String?,
    @SerialName("content")
    val content: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("publishedAt")
    val publishedAt: String?,
    @SerialName("source")
    val source: Source,
    @SerialName("title")
    val title: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("urlToImage")
    val urlToImage: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Source::class.java.classLoader)!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(author)
        dest.writeString(content)
        dest.writeString(description)
        dest.writeString(publishedAt)
        dest.writeParcelable(source, flags)
        dest.writeString(title)
        dest.writeString(url)
        dest.writeString(urlToImage)
    }

    companion object CREATOR : Parcelable.Creator<NewsModel> {
        override fun createFromParcel(parcel: Parcel): NewsModel {
            return NewsModel(parcel)
        }

        override fun newArray(size: Int): Array<NewsModel?> {
            return arrayOfNulls(size)
        }
    }
}
