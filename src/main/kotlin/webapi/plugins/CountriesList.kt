package webapi.plugins

import com.google.gson.annotations.SerializedName


class CountriesList
{

    data class CountryCode (
        @SerializedName("countryCode") val countryCode: String
    )
    {
        override fun toString(): String {
            return "CountryCode(countryCode='$countryCode')"
        }
    }

    data class Regions (
        @SerializedName("regions") val regions: ArrayList<String>
    )
    {
        override fun toString(): String {
            return "Regions(regions=$regions)"
        }
    }

    data class HolidayTypes (
        @SerializedName("holidayTypes") val holidayTypes: ArrayList<String>
    )
    {
        override fun toString(): String {
            return "HolidayTypes(holidayTypes=$holidayTypes)"
        }
    }

    data class CountryName (
        @SerializedName("fullName") val fullName: String
    )
    {
        override fun toString(): String {
            return "CountryName(fullName='$fullName')"
        }
    }

    data class FromDate(
        @SerializedName("day") val day: String,
        @SerializedName("month") val month: String,
        @SerializedName("year") val year: String,
    )
    {
        override fun toString(): String {
            return "FromDate(day='$day', month='$month', year='$year')"
        }
    }

    data class ToDate(
        @SerializedName("day") val day: String,
        @SerializedName("month") val month: String,
        @SerializedName("year") val year: String,
    )
    {
        override fun toString(): String {
            return "ToDate(day='$day', month='$month', year='$year')"
        }
    }

    override fun toString(): String {
        return super.toString()
    }
}