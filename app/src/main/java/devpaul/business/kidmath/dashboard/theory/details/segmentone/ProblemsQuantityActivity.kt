package devpaul.business.kidmath.dashboard.theory.details.segmentone

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import devpaul.business.kidmath.R

class ProblemsQuantityActivity : AppCompatActivity() {

    var textBack : TextView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems_quantity)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        textBack = findViewById(R.id.text_back)
        textBack?.setOnClickListener {
            onBackPressed()
        }
    }

}