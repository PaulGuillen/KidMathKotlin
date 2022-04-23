package devpaul.business.kidmath.operations.settings.details.segmenttwo

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import devpaul.business.kidmath.R

class MultDetailActivity : AppCompatActivity() {

    var textDialog : TextView? = null
    var textBack : TextView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mult_detail)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

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