package devpaul.business.kidmath

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.cardview.widget.CardView
import devpaul.business.kidmath.dashboard.news.NewsGameActivity
import devpaul.business.kidmath.dashboard.theory.TheoryActivity
import devpaul.business.kidmath.dashboard.operations.level.LevelActivity
import devpaul.business.kidmath.dashboard.profile.PerfilActivity
import devpaul.business.kidmath.dashboard.settings.SettingsActivity


class HomeActivity : AppCompatActivity() {

    var laySuma : CardView? = null
    var layResta : CardView? = null
    var layMultiplicar : CardView? = null
    var layDividir : CardView? = null

    var cardviewSettings : CardView? = null
    var cardViewPerfil : CardView? = null
    var carViewNews : CardView? = null
    var cardviewTeoria : CardView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        cardviewSettings = findViewById(R.id.cardview_ajustes)
        cardviewSettings?.setOnClickListener {
            val callInt = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(callInt)
        }

        cardViewPerfil = findViewById(R.id.cardview_perfil)
        cardViewPerfil?.setOnClickListener {
            val callInt = Intent(applicationContext, PerfilActivity::class.java)
            startActivity(callInt)
        }

        carViewNews = findViewById(R.id.cardview_noticias)
        carViewNews?.setOnClickListener {
            val callInt = Intent(applicationContext, NewsGameActivity::class.java)
            startActivity(callInt)
        }

        cardviewTeoria = findViewById(R.id.cardview_teoria)
        cardviewTeoria?.setOnClickListener {
            val callInt = Intent(applicationContext, TheoryActivity::class.java)
            startActivity(callInt)
        }

        laySuma = findViewById(R.id.cardview_suma)
        laySuma?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("sum","+")
            startActivity(callInt)
        }

        layResta = findViewById(R.id.cardview_resta)
        layResta?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("rest","-")
            startActivity(callInt)
        }


        layMultiplicar = findViewById(R.id.cardview_multiplicacion)
        layMultiplicar?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("mult","*")
            startActivity(callInt)
        }

        layDividir = findViewById(R.id.cardview_division)
        layDividir?.setOnClickListener {
            val callInt = Intent(applicationContext, LevelActivity::class.java)
            callInt.putExtra("div","/")
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