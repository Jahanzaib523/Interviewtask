package webapi.Database

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import webapi.ModelFiles.Countries

class DBManager
{
   //configuration
   private val hostname = "localhost:3306"
   private val databaseName = "interviewtask"
   private val username = "root"
   private val password = ""

   //database
   private val DB : Database

   init
   {
       val JDBC = "jdbc:mysql://$hostname/$databaseName?user=$username&password=$password&useUnicode=true&characterEncoding=UTF-8"
       DB = Database.connect(JDBC)
   }

   fun getCountriesList(): List<Task1Entity>
   {
      return DB.sequenceOf(Task1Table).toList()
   }
}