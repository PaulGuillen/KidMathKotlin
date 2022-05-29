package devpaul.business.kidmath.dashboard.operations.level

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import devpaul.business.kidmath.HomeActivity
import devpaul.business.kidmath.R
import devpaul.business.kidmath.dashboard.operations.div.DivGameActivity
import devpaul.business.kidmath.dashboard.operations.mult.MultGameActivity
import devpaul.business.kidmath.dashboard.operations.rest.RestGameActivity
import devpaul.business.kidmath.dashboard.operations.sum.SumGameActivity

class LevelActivity : AppCompatActivity() {

    var btnfacil : CardView? = null
    var btnintermedio : CardView? = null
    var btnavanzado : CardView? = null
    var btnexperto : CardView? = null
    var btnVolver : Button? = null


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        btnVolver = findViewById(R.id.btn_volver_dashboard)
        btnVolver?.setOnClickListener {
            val intent = Intent(this@LevelActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        btnfacil = findViewById(R.id.cardview_facil)
        btnfacil?.setOnClickListener {
            val suma = intent.getStringExtra("sum")
            if (suma == "+") {
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level", "Facil")
                startActivity(intent)
            }

            val rest = intent.getStringExtra("rest")
            if (rest == "-") {
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level", "Facil")
                startActivity(intent)
            }

            val multi = intent.getStringExtra("mult")
            if (multi == "*") {
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level", "Facil")
                startActivity(intent)
            }
            val div = intent.getStringExtra("div")
            if (div == "/") {
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level", "Facil")
                startActivity(intent)
            }
        }

        btnintermedio = findViewById(R.id.cardview_intermedio)
        btnintermedio?.setOnClickListener {
            val suma = intent.getStringExtra("sum")
            if (suma == "+") {
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level", "Intermedio")
                startActivity(intent)
            }

            val rest = intent.getStringExtra("rest")
            if (rest == "-") {
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level", "Intermedio")
                startActivity(intent)
            }

            val multi = intent.getStringExtra("mult")
            if (multi == "*") {
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level", "Intermedio")
                startActivity(intent)
            }
            val div = intent.getStringExtra("div")
            if (div == "/") {
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level", "Intermedio")
                startActivity(intent)
            }

        }


        btnavanzado = findViewById(R.id.cardview_avanzado)
        btnavanzado?.setOnClickListener {
            val suma = intent.getStringExtra("sum")
            if (suma == "+") {
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level", "Avanzado")
                startActivity(intent)
            }

            val rest = intent.getStringExtra("rest")
            if (rest == "-") {
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level", "Avanzado")
                startActivity(intent)
            }

            val multi = intent.getStringExtra("mult")
            if (multi == "*") {
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level", "Avanzado")
                startActivity(intent)
            }
            val div = intent.getStringExtra("div")
            if (div == "/") {
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level", "Avanzado")
                startActivity(intent)
            }
        }



        btnexperto = findViewById(R.id.cardview_experto)
        btnexperto?.setOnClickListener {
            val suma = intent.getStringExtra("sum")
            if (suma == "+") {
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level", "Experto")
                startActivity(intent)
            }

            val rest = intent.getStringExtra("rest")
            if (rest == "-") {
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level", "Experto")
                startActivity(intent)
            }

            val multi = intent.getStringExtra("mult")
            if (multi == "*") {
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level", "Experto")
                startActivity(intent)
            }
            val div = intent.getStringExtra("div")
            if (div == "/") {
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level", "Experto")
                startActivity(intent)
            }
        }
    }

}