package devpaul.business.kidmath.dashboard.theory.details

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetSequence
import devpaul.business.kidmath.HomeActivity
import devpaul.business.kidmath.R
import devpaul.business.kidmath.dashboard.theory.TheoryActivity

class GameDetailActivity : AppCompatActivity() {

    var tvTimer: TextView? = null
    var tvPoints: TextView? = null
    var tvSum: TextView? = null
    var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)


        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        tvTimer = findViewById(R.id.tvTimer)
        tvPoints = findViewById(R.id.tvPoints)
        tvSum = findViewById(R.id.tvSum)
        tvResult = findViewById(R.id.tvResult)

        (
                TapTargetSequence(this)
                    .targets (
                        TapTarget.forView(tvTimer, "Contador decreciente", "El contador sera del segundo 30 hasta el segundo 0 en el cual finalizará el tiempo")
                            .outerCircleColor(R.color.teal_200)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(25)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(20)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true),
                        TapTarget.forView(tvPoints, "Puntos obtenidos", "Respuestas correctas del total respondido, el cual muestra tu puntaje.")
                            .outerCircleColor(R.color.teal_200)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(25)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(20)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true),
                        TapTarget.forView(tvSum, "Resultado de la operación", "Procura realizar la mayor cantidad de puntos con el resultado indicado, así ejercitarás tu mente.")
                            .outerCircleColor(R.color.teal_200)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(25)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(20)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true),
                        TapTarget.forView(tvResult, "Respuesta Correcta o Incorrecta", "Mostará si el resultado es correcto o incorrecto dependiendo de la operación realizada.")
                            .outerCircleColor(R.color.teal_200)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(25)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(20)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                    ).listener(object : TapTargetSequence.Listener {
                        override fun onSequenceFinish() {
                            val i = Intent(applicationContext, HomeActivity::class.java)
                            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(i)
                        }

                        fun onSequenceStep(lastTarget: TapTarget?, targetClicked: Boolean) {

                        }

                        override fun onSequenceCanceled(lastTarget: TapTarget) {}
                    }).start())


    }
}