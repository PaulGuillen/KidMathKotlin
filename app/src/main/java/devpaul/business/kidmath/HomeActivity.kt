package devpaul.business.kidmath

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import android.os.Build
import android.view.View
import android.widget.ImageButton
import devpaul.business.kidmath.operations.settings.SettingsActivity
import devpaul.business.kidmath.operations.level.LevelActivity


class HomeActivity : AppCompatActivity() {

    var laySuma : ImageButton? = null
    var layResta : ImageButton? = null
    var layDivision : ImageButton? = null
    var layMultiplicar : ImageButton? = null

    var ibsettings : ImageButton? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        ibsettings = findViewById(R.id.ibSettings)
        ibsettings?.setOnClickListener {
            val callInt = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(callInt)
        }


        laySuma = findViewById(R.id.btn_suma)
        laySuma?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("sum","+")
            startActivity(callInt)
        }

        layResta = findViewById(R.id.btn_resta)
        layResta?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("rest","-")
            startActivity(callInt)
        }


        layMultiplicar = findViewById(R.id.btn_multiplicar)
        layMultiplicar?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("mult","*")
            startActivity(callInt)
        }
        layDivision = findViewById(R.id.btn_division)
        layDivision?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("divi","/")
            startActivity(callInt)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)

    }



}