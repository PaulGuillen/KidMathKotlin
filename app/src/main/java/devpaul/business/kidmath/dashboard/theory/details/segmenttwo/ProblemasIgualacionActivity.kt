package devpaul.business.kidmath.dashboard.theory.details.segmenttwo

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import devpaul.business.kidmath.R

class ProblemasIgualacionActivity : AppCompatActivity() {

    var textDialog : TextView? = null
    var textBack : TextView? = null
    var textsigno : TextView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problemas_igualacion)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        textsigno = findViewById(R.id.text_signo)
        textsigno?.text = "?"

        textDialog = findViewById(R.id.next)
        textDialog?.setOnClickListener {
            SweetAlertDialog(this).setTitleText("Segimos trabajando en este tema, gracias por tu comprensión").show()
        }

        textBack = findViewById(R.id.text_back)
        textBack?.setOnClickListener {
            onBackPressed()
        }
    }
}