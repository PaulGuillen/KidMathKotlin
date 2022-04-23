package devpaul.business.kidmath.operations.level

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import devpaul.business.kidmath.R
import devpaul.business.kidmath.operations.div.DivGameActivity
import devpaul.business.kidmath.operations.mult.MultGameActivity
import devpaul.business.kidmath.operations.rest.RestGameActivity
import devpaul.business.kidmath.operations.sum.SumGameActivity

class LevelActivity : AppCompatActivity() {

    var btnlvl1 : Button? = null
    var btnlvl2 : Button? = null
    var btnlvl3 : Button? = null
    var btnlvl4 : Button? = null
    var btnlvl5 : Button? = null
    var btnlvl6 : Button? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        btnlvl1 = findViewById(R.id.button1)
        btnlvl1?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","one")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","one")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","one")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","one")
                startActivity(intent)
            }

        }
        btnlvl2 = findViewById(R.id.button2)
        btnlvl2?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","two")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","two")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","two")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","two")
                startActivity(intent)
            }
        }
        btnlvl3 = findViewById(R.id.button3)
        btnlvl3?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","third")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","third")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","third")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","third")
                startActivity(intent)
            }
        }
        btnlvl4 = findViewById(R.id.button4)
        btnlvl4?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","four")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","four")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","four")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","four")
                startActivity(intent)
            }
        }
        btnlvl5 = findViewById(R.id.button5)
        btnlvl5?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","five")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","five")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","five")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","five")
                startActivity(intent)
            }
        }
        btnlvl6 = findViewById(R.id.button6)
        btnlvl6?.setOnClickListener {
            val suma= intent.getStringExtra("sum")
            if (suma == "+"){
                val intent = Intent(this@LevelActivity, SumGameActivity::class.java)
                intent.putExtra("level","six")
                startActivity(intent)
            }

            val rest= intent.getStringExtra("rest")
            if (rest == "-"){
                val intent = Intent(this@LevelActivity, RestGameActivity::class.java)
                intent.putExtra("level","six")
                startActivity(intent)
            }

            val multi= intent.getStringExtra("mult")
            if (multi == "*"){
                val intent = Intent(this@LevelActivity, MultGameActivity::class.java)
                intent.putExtra("level","six")
                startActivity(intent)
            }

            val divi= intent.getStringExtra("divi")
            if (divi == "/"){
                val intent = Intent(this@LevelActivity, DivGameActivity::class.java)
                intent.putExtra("level","six")
                startActivity(intent)
            }
        }

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}