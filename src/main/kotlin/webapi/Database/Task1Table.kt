package webapi.Database

import org.ktorm.schema.Table
import org.ktorm.schema.text
import org.ktorm.entity.Entity

object Task1Table : Table<Task1Entity>("countrieslist")
{
    val code = text("CCode").primaryKey().bindTo { it.code }
    val name = text("CName").bindTo {  it.name }
}

interface Task1Entity: Entity<Task1Entity>
{
   companion object: Entity.Factory<Task1Entity>()
   val code: String
   val name: String
}