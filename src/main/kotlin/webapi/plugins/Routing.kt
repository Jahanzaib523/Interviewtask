package webapi.plugins

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.reflect.*
import webapi.Interfaces.Task1ToDoInterface
import webapi.ModelFiles.Countries
import webapi.MySQLRepository.Task1.Task1ToDo

fun Application.configureRouting()
{
    install(ContentNegotiation)
    {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }
    val client = HttpClient(CIO) {
        expectSuccess = false
    }
    routing {

        val storage : Task1ToDoInterface = Task1ToDo()
        val countryN : CountriesList.CountryName
        val countryC : CountriesList.CountryCode

        get("/HolidaysForGivenYear")
        {
            val httpresp: HttpResponse = client.get("https://kayaposoft.com/enrico/json/v2.0/?action=getHolidaysForYear&year=2022&country=est&holidayType=public_holiday")
            val strholidays: String = httpresp.receive()

            val gson = Gson()

            val countryC :  List<Holidays.CountryCode> = gson.fromJson(strholidays, Array<Holidays.CountryCode>::class.java).toList()
            val countryD : List<Holidays.Date> = gson.fromJson(strholidays, Array<Holidays.Date>::class.java).toList()
            val holidayType: List<Holidays.HolidayType> = gson.fromJson(strholidays, Array<Holidays.HolidayType>::class.java).toList()

            for (i in countryC.indices)
            {
                //val temp : Countries = Countries(countryD[i].date)
                print(countryD[i].date)
                print(countryC[i].name)
                print(holidayType[i].holidayType)
                //storage.AddRecord(temp)
            }
        }

        get("/countries")
        {
            val httpResponse: HttpResponse = client.get("https://kayaposoft.com/enrico/json/v2.0/?action=getSupportedCountries")
            val str: String = httpResponse.receive()

            val gson = Gson()

            val countryN :  List<CountriesList.CountryName> = gson.fromJson(str, Array<CountriesList.CountryName>::class.java).toList()
            val countryC : List<CountriesList.CountryCode> = gson.fromJson(str, Array<CountriesList.CountryCode>::class.java).toList()

            for (i in countryN.indices)
            {
                val temp : Countries = Countries(countryC[i].countryCode, countryN[i].fullName)
                storage.AddRecord(temp)
            }
        }

        post("/")
        {
            call.respond("Hello")
        }
    }
}
