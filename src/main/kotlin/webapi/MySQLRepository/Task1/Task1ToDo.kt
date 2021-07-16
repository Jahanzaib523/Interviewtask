package webapi.MySQLRepository.Task1

import webapi.Database.DBManager
import webapi.Interfaces.Task1ToDoInterface
import webapi.ModelFiles.Countries
import webapi.ModelFiles.Draft

class Task1ToDo : Task1ToDoInterface
{
    private val list = mutableListOf<Countries>()

    private val database = DBManager()

    override fun getAllToDos(): List<Countries>
    {
      return database.getCountriesList().map { Countries(it.code, it.name)}
    }

    override fun AddRecord(countries: Countries): Countries
    {
        list.add(countries)
        return countries
    }
}