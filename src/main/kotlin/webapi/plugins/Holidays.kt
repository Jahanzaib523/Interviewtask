package webapi.plugins

import com.google.gson.annotations.SerializedName

class Holidays
{
    data class Date (
        @SerializedName("date") val date: Fields,
    )
    {
        override fun toString(): String {
            return "Date(date=$date)"
        }
    }

    data class CountryCode (
        @SerializedName("name") val name: ArrayList<Name>
    )
    {
        override fun toString(): String {
            return "CountryCode(name=$name)"
        }
    }

    data class HolidayType (
        @SerializedName("holidayType") val holidayType: String
    )
    {
        override fun toString(): String {
            return "HolidayType(holidayType='$holidayType')"
        }
    }

    data class Name(
        @SerializedName("lang") val lang: String,
        @SerializedName("text") val text: String
    )
    {
        override fun toString(): String {
            return "Name(lang='$lang', text='$text')"
        }
    }

    data class Fields(
        @SerializedName("day") val day: String,
        @SerializedName("month") val month: String,
        @SerializedName("year") val year: String,
        @SerializedName("dayOfWeek") val daysofweek: String
    )
    {
        override fun toString(): String {
            return "Date(day='$day', month='$month', year='$year', daysofweek='$daysofweek')"
        }
    }
}