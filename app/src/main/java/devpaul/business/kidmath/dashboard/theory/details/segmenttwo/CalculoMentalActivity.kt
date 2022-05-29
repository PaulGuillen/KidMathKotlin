package devpaul.business.kidmath.dashboard.theory.details.segmenttwo

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import devpaul.business.kidmath.R

class CalculoMentalActivity : AppCompatActivity() {

    var textBack : TextView? = null

    var edtUno : TextView ? = null
    var edtDos : TextView ? = null
    var edtTres : TextView ? = null
    var edtCuatro : TextView ? = null
    var edtCinco : TextView ? = null
    var edtSeis : TextView ? = null
    var edtSiete : TextView ? = null
    var edtOcho : TextView ? = null
    var edtNueve : TextView ? = null
    var edtDiez : TextView ? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_mental)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        edtUno = findViewById(R.id.edt_uno)
        edtDos = findViewById(R.id.edt_dos)
        edtTres = findViewById(R.id.edt_tres)
        edtCuatro = findViewById(R.id.edt_cuatro)
        edtCinco = findViewById(R.id.edt_cinco)
        edtSeis = findViewById(R.id.edt_seis)
        edtSiete = findViewById(R.id.edt_siete)
        edtOcho = findViewById(R.id.edt_ocho)
        edtNueve = findViewById(R.id.edt_nueve)
        edtDiez = findViewById(R.id.edt_diez)

        edtUno?.text = "?"
        edtDos?.text = "?"
        edtTres?.text = "?"
        edtCuatro?.text = "?"
        edtCinco?.text = "?"
        edtSeis?.text = "?"
        edtSiete?.text = "?"
        edtOcho?.text = "?"
        edtNueve?.text = "?"
        edtDiez?.text = "?"


        textBack = findViewById(R.id.text_back)
        textBack?.setOnClickListener {
            onBackPressed()
        }

    }


}