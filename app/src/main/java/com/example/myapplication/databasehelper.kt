import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.myapplication.Trip

class myDBhelper (context:Context) : SQLiteOpenHelper (context, "DATABASE", null,1){
    override fun onCreate (db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS TRIPS (tripID INTEGER PRIMARY KEY AUTOINCREMENT, tripNAME TEXT, destination TEXT, tripStartDate LONG, tripEndDate LONG)")
        //db?.execSQL("INSERT INTO TRIPS (tripNAME, destination) VALUES ('testname', 'testdestination')")
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
            Toast.makeText(myCtx,"No records found!", Toast.LENGTH_SHORT).show()
        else {
            while (cursor.moveToNext()) {
                val trip = Trip()
                trip.tripID = cursor.getInt(0)
                trip.tripNAME = cursor.getString(1)
                trip.destination=cursor.getString(2)
                trip.tripStartDate=cursor.getLong(3)
                trip.tripEndDate=cursor.getLong(4)
                trips.add(trip)
            }
        }
        cursor.close()
        db.close()
        return trips
    }

}