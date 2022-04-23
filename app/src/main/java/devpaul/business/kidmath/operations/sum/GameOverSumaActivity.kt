package devpaul.business.kidmath.operations.sum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import devpaul.business.kidmath.Constants
import devpaul.business.kidmath.HomeActivity
import devpaul.business.kidmath.R
import devpaul.business.kidmath.model.Points
import java.text.SimpleDateFormat
import java.util.*


class GameOverSumaActivity : AppCompatActivity() {

    var TAG = "GameOverSuma"

    var tvPoints: TextView? = null
    var sharedPreferences: SharedPreferences? = null
    var ivHighScore: ImageView? = null
    var tvHighScore: TextView? = null
    var tvName: TextView? = null
    var tvLastname: TextView? = null

    //Firebase extensiones
    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore


    @SuppressLint("SetTextI18n", "SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over_sum)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        auth = Firebase.auth

        ivHighScore = findViewById(R.id.ivHighScore)
        tvHighScore = findViewById(R.id.tvHighScore)
        tvPoints = findViewById(R.id.tvPoints)
        tvName = findViewById(R.id.nombre)
        tvLastname = findViewById(R.id.apellido)

        sharedPreferences = getSharedPreferences("prefsuma", 0)
        val points = intent.extras!!.getInt("points")
        var pointsSP = sharedPreferences?.getInt("pointsSP", 0)
        val editor = sharedPreferences?.edit()
        if (points > pointsSP!!) {
            pointsSP = points
            editor?.putInt("pointsSP", pointsSP)
            editor?.apply()
            ivHighScore?.visibility = View.VISIBLE
        }
        tvPoints?.text = "" + points
        tvHighScore?.text = "" + pointsSP


        getUserData()


    }


    private fun getUserData(): Boolean {
        val user = FirebaseFirestore.getInstance()
        val uid = auth.currentUser?.uid
        val usersRef = user.collection(Constants.PATH_USERS)
        usersRef.document(uid!!).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document.exists()) {
                    val name = document.getString("name")
                    val lastname = document.getString("lastname")

                    tvName?.text = name
                    tvLastname?.text = lastname

                    sendData()

                }

            }
        }

        return true
    }

    @SuppressLint("SimpleDateFormat")
    private fun sendData() {

        FirebaseAuth.getInstance().currentUser?.metadata?.apply {

            val uiduser = auth.currentUser?.uid
            val bestPoints = tvHighScore?.text.toString() + "\r" + "puntos"
            val lastTry = tvPoints?.text.toString() + "\r" + "puntos"
            val name = tvName?.text.toString()
            val lastname = tvLastname?.text.toString()

            // LasTimeJoinTotheApp
            val lastSignInDate = Date(lastSignInTimestamp)
            val lastTimeAccess = SimpleDateFormat("yyyy/MM/dd").format(lastSignInDate)

            // LastTimePLayed
            val date = getCurrentDateTime()
            val dateInString = date.toString("yyyy/MM/dd")

            val dataPoints = Points(
                uiduser.toString(),
                name,
                lastname,
                bestPoints,
                lastTry,
                dateInString,
                lastTimeAccess
            )

            val datapointsget = dataPoints.bestPoints
            Log.v(TAG, "UID : $datapointsget")

            db.collection(Constants.PATH_POINTS_SUM).document(uiduser.toString())
                .set(dataPoints)
                .addOnSuccessListener {
                    Log.v(TAG, "Success : $it")
                }
                .addOnFailureListener { e ->
                    Log.v(TAG, "Error : $e")
                }

        }

    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun restart(view: View?) {
        val intent = Intent(this@GameOverSumaActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun exit(view: View?) {
        finish()
    }
}