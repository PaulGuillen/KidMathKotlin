package devpaul.business.kidmath.dashboard.operations.mult

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
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import devpaul.business.kidmath.Constants
import devpaul.business.kidmath.HomeActivity
import devpaul.business.kidmath.R
import devpaul.business.kidmath.dashboard.operations.level.LevelActivity
import devpaul.business.kidmath.dashboard.operations.sum.SumGameActivity
import devpaul.business.kidmath.model.Points
import java.text.SimpleDateFormat
import java.util.*

class GameOverMultiplicacionActivity : AppCompatActivity() {

    var TAG = "GameOverMultip"

    var tvPoints: TextView? = null
    var sharedPreferences: SharedPreferences? = null
    var ivHighScore: ImageView? = null
    var tvHighScore: TextView? = null

    var tvName : TextView ? = null
    var tvLastname : TextView ? = null

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore

    var tvNext: TextView? = null

    private val database = Firebase.database
    private val myref = database.getReference("Users")

    @SuppressLint("SetTextI18n", "SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over_mult)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        auth = Firebase.auth

        tvNext = findViewById(R.id.next)
        tvNext?.setOnClickListener {
            nextlevel()
        }


        ivHighScore = findViewById(R.id.ivHighScore)
        tvHighScore = findViewById(R.id.tvHighScore)
        val points = intent.extras!!.getInt("points")
        tvPoints = findViewById(R.id.tvPoints)

        tvName = findViewById(R.id.nombre)
        tvLastname = findViewById(R.id.apellido)

        sharedPreferences = getSharedPreferences("prefmult", 0)
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



    private fun getUserData() : Boolean {
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
    private fun sendData(){

        FirebaseAuth.getInstance().currentUser?.metadata?.apply {

            val uiduser = auth.currentUser?.uid
            val bestPoints = tvHighScore?.text.toString() + "\r" + "puntos"
            val lastTry = tvPoints?.text.toString() + "\r" + "puntos"
            val name = tvName?.text.toString()
            val lastname = tvLastname?.text.toString()

            // LasTimeJoinTotheApp
            val lastSignInDate = Date(lastSignInTimestamp)
            val lastTimeAccess = SimpleDateFormat("yyyy/MM/dd").format(lastSignInDate)

            // lastTimePlayed
            val date = getCurrentDateTime()
            val dateInString = date.toString("yyyy/MM/dd")

            val randomUUID = UUID.randomUUID().toString()

            val timePlayed = 60
            val type = "Multiplicacion"

            val level = intent.getStringExtra("level")

            val incorrectAnswers = intent.extras!!.getInt("incorrectAnswers")
            val correctAnswers = intent.extras!!.getInt("points")
            val numberofQuestions = intent.extras!!.getInt("numberQuestions")

            val dataPoints = Points(uiduser.toString(), name, lastname, bestPoints, lastTry, dateInString, lastTimeAccess, incorrectAnswers
                ,numberofQuestions, correctAnswers,timePlayed, type, level)

            db.collection(Constants.PATH_POINTS_MUL).document(uiduser.toString())
                .set(dataPoints)
                .addOnSuccessListener {
                    Log.v(TAG,"Success : $it")
                    db.collection("AllResultsMul").document(randomUUID).set(dataPoints);
                    myref.child("AllResultsMul").child(randomUUID).setValue(dataPoints)
                }
                .addOnFailureListener { e ->
                    Log.v(TAG,"Error : $e")
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
        finish()
    }

    fun exit(view: View?) {
        val intent = Intent(this@GameOverMultiplicacionActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun nextlevel() {
        val level = intent.getStringExtra("level")
        if (level == "Facil") {
            val intent = Intent(this@GameOverMultiplicacionActivity, MultGameActivity::class.java)
            intent.putExtra("level", "Intermedio")
            startActivity(intent)
            finish()
        }

        if (level == "Intermedio") {
            val intent = Intent(this@GameOverMultiplicacionActivity, MultGameActivity::class.java)
            intent.putExtra("level", "Avanzado")
            startActivity(intent)
            finish()
        }


        if (level == "Avanzado") {
            val intent = Intent(this@GameOverMultiplicacionActivity, MultGameActivity::class.java)
            intent.putExtra("level", "Experto")
            startActivity(intent)
            finish()
        }

        if (level == "Experto") {

            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE).setTitleText("Comunicado")
                .setContentText("Actualmente no hay mas niveles que mostrar.")
                .setConfirmText("Ok")
                .setConfirmClickListener { sDialog -> // Showing simple toast message to user
                    val i = Intent(this, LevelActivity::class.java)
                    i.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Eliminar el historial de pantallas
                    startActivity(i)
                    sDialog.dismissWithAnimation()
                }.show()
        }
    }
}