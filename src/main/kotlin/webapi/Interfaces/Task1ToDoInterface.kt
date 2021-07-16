package webapi.Interfaces

import webapi.ModelFiles.Countries
import webapi.ModelFiles.Draft

interface Task1ToDoInterface
{
    fun getAllToDos(): List<Countries>

    fun AddRecord(countries: Countries) : Countries
}
