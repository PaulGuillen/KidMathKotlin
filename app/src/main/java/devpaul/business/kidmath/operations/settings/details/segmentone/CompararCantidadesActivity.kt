package devpaul.business.kidmath.operations.settings.details.segmentone

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import devpaul.business.kidmath.R

class CompararCantidadesActivity : AppCompatActivity() {

    var textDialog : TextView? = null
    var textBack : TextView? = null

    var textview1 : TextView? = null
    var textview2 : TextView? = null
    var textview3 : TextView? = null
    var textview4 : TextView? = null
    var textview5 : TextView? = null
    var textview6 : TextView? = null
    var textview7 : TextView? = null
    var textview8 : TextView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_cantidades)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        textview1 = findViewById(R.id.textView5)
        textview1?.text = "<"

        textview2 = findViewById(R.id.textView8)
        textview2?.text = "="

        textview3 = findViewById(R.id.textView11)
        textview3?.text = ">"

        textview4 = findViewById(R.id.textView14)
        textview4?.text = "="

        textview5 = findViewById(R.id.textView17)
        textview5?.text = "<"

        textview6 = findViewById(R.id.textView20)
        textview6?.text = ">"

        textview7 = findViewById(R.id.textView23)
        textview7?.text = "="

        textview8 = findViewById(R.id.textView26)
        textview8?.text = ">"

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