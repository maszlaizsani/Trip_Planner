import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.myapplication.Trip

class myDBhelper (context:Context) : SQLiteOpenHelper (context, "DATABASE", null,1){
    override fun onCreate (db: SQLiteDatabase?) {
        val query="CREATE TABLE IF NOT EXISTS TRIPS (tripID INTEGER PRIMARY KEY AUTOINCREMENT, tripNAME TEXT, destinations TEXT, tripStartDate LONG, tripEndDate LONG, tripNote TEXT, categories TEXT, activities TEXT, cities TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun getTrips(myCtx: Context) : ArrayList<Trip> {
        val qry= "SELECT * FROM TRIPS"
        val db =this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val trips=ArrayList<Trip>()

        if (cursor.count==0)
            Toast.makeText(myCtx,"No plans yet!", Toast.LENGTH_SHORT).show()
        else {
            while (cursor.moveToNext()) {
                val trip = Trip()
                trip.tripID = cursor.getInt(0)
                trip.tripNAME = cursor.getString(1)
                trip.destinations=cursor.getString(2)
                trip.tripStartDate=cursor.getLong(3)
                trip.tripEndDate=cursor.getLong(4)
                trip.tripNote=cursor.getString(5)
                trip.categories=cursor.getString(6)
                trip.activities=cursor.getString(7)
                trip.cities=cursor.getString(8)
                trips.add(trip)
            }
        }
        cursor.close()
        db.close()
        return trips
    }

    fun getTripDetails(myCtx: Context, name: String): Trip {
        val qry= "SELECT * FROM TRIPS WHERE tripNAME='$name'"
        val db=this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val trip=Trip()
        if (cursor.count==0)
            Toast.makeText(myCtx,"Something went wrong", Toast.LENGTH_SHORT).show()
        else {
            cursor.moveToFirst()
            trip.tripID = cursor.getInt(0)
            trip.tripNAME = cursor.getString(1)
            trip.destinations = cursor.getString(2)
            trip.tripStartDate = cursor.getLong(3)
            trip.tripEndDate = cursor.getLong(4)
            trip.tripNote = cursor.getString(5)
            trip.categories = cursor.getString(6)
            trip.activities = cursor.getString(7)
            trip.cities = cursor.getString(8)

          //  Toast.makeText(myCtx,trip.tripNAME + " "+ trip.destination,Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db.close()
        return trip
    }

}