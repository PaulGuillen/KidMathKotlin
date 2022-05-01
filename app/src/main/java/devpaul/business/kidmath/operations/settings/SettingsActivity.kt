package devpaul.business.kidmath.operations.settings


import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import devpaul.business.kidmath.R
import devpaul.business.kidmath.login.LoginActivity
import devpaul.business.kidmath.operations.settings.details.*
import devpaul.business.kidmath.operations.settings.details.segmentone.CentenasActivity
import devpaul.business.kidmath.operations.settings.details.segmentone.CompararCantidadesActivity
import devpaul.business.kidmath.operations.settings.details.segmentone.DecimalDetailActivity
import devpaul.business.kidmath.operations.settings.details.segmentone.ProblemsQuantityActivity
import devpaul.business.kidmath.operations.settings.details.segmentthree.CuerposGeometricoActivity
import devpaul.business.kidmath.operations.settings.details.segmentthree.DivDetailActivity
import devpaul.business.kidmath.operations.settings.details.segmentthree.FracDetailActivity
import devpaul.business.kidmath.operations.settings.details.segmentthree.InterpretacionGraficosActivity
import devpaul.business.kidmath.operations.settings.details.segmenttwo.*

class SettingsActivity : AppCompatActivity() {

    var btnSalir : Button? = null

    var btnProblemsQuantity : Button ? = null
    var btnDecimal : Button ? = null
    var btnCentenas : Button ? = null
    var btnOrdenarCantidades : Button ? = null
    var btnMultiplicacion : Button ? = null
    var btncalculomental : Button ? = null
    var btnComparacion : Button ? = null
    var btnIgualacion : Button ? = null


    var btnTeoriaDivision: Button ? = null
    var btnFracciones: Button ? = null
    var btnGameDetail: Button ? = null
    var btnMultiplo: Button ? = null
    var btnGrafico: Button ? = null
    var btnInterpretacionGraficos: Button ? = null
    var btnCuerposGeometrico: Button ? = null

    private lateinit var auth: FirebaseAuth

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        auth = Firebase.auth

        btnSalir = findViewById(R.id.btn_salir)
        btnSalir?.setOnClickListener {
            auth.signOut()
            val i = Intent(this, LoginActivity::class.java)
            Toast.makeText(this,"Gracias por visitarnos",Toast.LENGTH_LONG).show()
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Eliminar el historial de pantallas
            startActivity(i)
        }

        btnProblemsQuantity = findViewById(R.id.btn_problemas_cantidades)
        btnProblemsQuantity?.setOnClickListener {
            val i = Intent(this, ProblemsQuantityActivity::class.java)
            startActivity(i)
        }
        btnDecimal = findViewById(R.id.viewSegmentDecimal)
        btnDecimal?.setOnClickListener {
            val i = Intent(this, DecimalDetailActivity::class.java)
            startActivity(i)
        }

        btnCentenas = findViewById(R.id.btn_centenas)
        btnCentenas?.setOnClickListener {
            val i = Intent(this, CentenasActivity::class.java)
            startActivity(i)
        }

        btnOrdenarCantidades = findViewById(R.id.comparar_cantidades)
        btnOrdenarCantidades?.setOnClickListener {
            val i = Intent(this, CompararCantidadesActivity::class.java)
            startActivity(i)
        }

        //Segment two
        btnMultiplicacion = findViewById(R.id.btn_multiplicacion)
        btnMultiplicacion?.setOnClickListener {
            val i = Intent(this, MultDetailActivity::class.java)
            startActivity(i)
        }

        btncalculomental = findViewById(R.id.btncalculomental)
        btncalculomental?.setOnClickListener {
            val i = Intent(this, CalculoMentalActivity::class.java)
            startActivity(i)
        }
        btnComparacion = findViewById(R.id.btn_comparacion)
        btnComparacion?.setOnClickListener {
            val i = Intent(this, ProblemasComparacionActivity::class.java)
            startActivity(i)
        }
        btnIgualacion = findViewById(R.id.btnIgualacion)
        btnIgualacion?.setOnClickListener {
            val i = Intent(this, ProblemasIgualacionActivity::class.java)
            startActivity(i)
        }

        btnTeoriaDivision = findViewById(R.id.btn_teoria_division)
        btnTeoriaDivision?.setOnClickListener {
            val i = Intent(this, DivDetailActivity::class.java)
            startActivity(i)
        }

        btnFracciones = findViewById(R.id.btn_fracciones)
        btnFracciones?.setOnClickListener {
            val i = Intent(this, FracDetailActivity::class.java)
            startActivity(i)
        }

        btnGameDetail = findViewById(R.id.btn_game_detail)
        btnGameDetail?.setOnClickListener {
            val i = Intent(this, GameDetailActivity::class.java)
            startActivity(i)
        }
        btnMultiplo = findViewById(R.id.btnMultiplo)
        btnMultiplo?.setOnClickListener {
            val i = Intent(this, MultiplosNumerosActivity::class.java)
            startActivity(i)
        }
        btnGrafico = findViewById(R.id.btnGrafico)
        btnGrafico?.setOnClickListener {
            val i = Intent(this, GraficoBarrasActivity::class.java)
            startActivity(i)
        }
        btnInterpretacionGraficos = findViewById(R.id.btnInterpretacionGraficos)
        btnInterpretacionGraficos?.setOnClickListener {
            val i = Intent(this, InterpretacionGraficosActivity::class.java)
            startActivity(i)
        }

        btnCuerposGeometrico = findViewById(R.id.btnCuerposGeometrico)
        btnCuerposGeometrico?.setOnClickListener {
            val i = Intent(this, CuerposGeometricoActivity::class.java)
            startActivity(i)
        }

    }

}