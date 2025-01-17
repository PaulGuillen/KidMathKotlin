package devpaul.business.kidmath.dashboard.operations.div

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import devpaul.business.kidmath.R
import kotlin.random.Random

class DivGameActivity : AppCompatActivity() {

    val TAG = "DivGame"
    var op1: Int? = null
    var op2: Int? = null
    var div: Int? = null
    var divOther: Int? = null

    var tvTimer: TextView? = null
    var tvPoints: TextView? = null
    var tvSum: TextView? = null
    var tvResult: TextView? = null
    var btn0: Button? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null

    var countDownTimer: CountDownTimer? = null
    var millisUntilFinished: Long? = null

    lateinit var btnIds: IntArray
    var correctAnswerPosition = 0
    var incorrectAnswers: ArrayList<Int>? = null

    var points = 0
    var numberofQuestions = 0
    var random: Random = Random

    var textlevel : TextView? =null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_div_game)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        op1 = 0
        op2 = 0
        div = 0
        tvTimer = findViewById(R.id.tvTimer)
        tvPoints = findViewById(R.id.tvPoints)
        tvSum = findViewById(R.id.tvSum)
        tvResult = findViewById(R.id.tvResult)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        textlevel = findViewById(R.id.text_level)

        btnIds = intArrayOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3)
        correctAnswerPosition = 0
        incorrectAnswers = ArrayList()
        millisUntilFinished = 60100
        incorrectAnswers = ArrayList()


        val level = intent.getStringExtra("level")
        if (level == "Facil"){
            easylevelgame()
            textlevel?.text = "Nivel Fácil"
        }
        if (level == "Intermedio"){
            intermediateLevel()
            textlevel?.text = "Nivel Intermedio"
        }
        if (level == "Avanzado"){
            advancedlevel()
            textlevel?.text = "Nivel Avanzado"
        }

        if (level == "Experto") {
            expertlevel()
            textlevel?.text = "Nivel Experto"
        }

    }

    fun chooseAnswer(view: View) {
        val answer = (view as Button).text.toString().toInt()
        if (answer == div) {
            points++
            tvResult!!.text = "Correcto!"
        } else {
            tvResult!!.text = "Incorrecto!"
        }
        tvPoints!!.text = "$points/$numberofQuestions"

        val level = intent.getStringExtra("level")
        if (level == "Facil"){
            generateQuestionEasy()
        }

        if (level == "Intermedio"){
            generateQuestionIntermediate()
        }

        if (level == "Avanzado"){
            generateQuestionAdvanced()
        }

        if (level == "Experto"){
            generateQuestionExpert()
        }


    }


    @SuppressLint("SetTextI18n")
    private fun easylevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionEasy()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@DivGameActivity, GameOverDivisionActivity::class.java)
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                intent.putExtra("points", points)
                intent.putExtra("level", "Facil")
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionEasy() {
        numberofQuestions++
        op1 = random.nextInt(16, 40)
        op2 = random.nextInt(1, 15)
        div = op1!! / op2!!
        tvSum?.text = "$op1 / $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + div
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(20, 60)
            op2 = random.nextInt(1, 10)
            divOther = op1!! / op2!!
            if (divOther == div) {
                continue
            }
            incorrectAnswers?.add(divOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //SecondLevelGame
    @SuppressLint("SetTextI18n")
    private fun intermediateLevel() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionIntermediate()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent =
                    Intent(this@DivGameActivity, GameOverDivisionActivity::class.java)
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                intent.putExtra("points", points)
                intent.putExtra("level", "Intermedio")
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionIntermediate() {
        numberofQuestions++
        op1 = random.nextInt(30, 90)
        op2 = random.nextInt(5, 25)
        div = op1!! / op2!!
        tvSum?.text = "$op1 / $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + div
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(30, 90)
            op2 = random.nextInt(5, 25)
            divOther = op1!! / op2!!
            if (divOther == div) {
                continue
            }
            incorrectAnswers?.add(divOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Third Level Game
    @SuppressLint("SetTextI18n")
    private fun advancedlevel() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionAdvanced()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@DivGameActivity, GameOverDivisionActivity::class.java)
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                intent.putExtra("points", points)
                intent.putExtra("level", "Avanzado")
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionAdvanced() {
        numberofQuestions++
        op1 = random.nextInt(50,100)
        op2 = random.nextInt(5,45)
        div = op1!! / op2!!
        tvSum?.text = "$op1 / $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + div
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(50,100)
            op2 = random.nextInt(5,45)
            divOther = op1!! / op2!!
            if (divOther == div) {
                continue
            }
            incorrectAnswers?.add(divOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }


    //Fourth Level Game
    @SuppressLint("SetTextI18n")
    private fun expertlevel() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionExpert()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@DivGameActivity, GameOverDivisionActivity::class.java)
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                intent.putExtra("points", points)
                intent.putExtra("level", "Experto")
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionExpert() {
        numberofQuestions++
        op1 = random.nextInt(80,150)
        op2 = random.nextInt(5,50)
        div = op1!! / op2!!
        tvSum?.text = "$op1 / $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + div
        while (true) {
            if (incorrectAnswers!!.size > 4) break
            op1 = random.nextInt(80,150)
            op2 = random.nextInt(5,50)
            divOther = op1!! / op2!!
            if (divOther == div) {
                continue
            }
            incorrectAnswers?.add(divOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }



    override fun onBackPressed() {
        super.onBackPressed()
        countDownTimer?.cancel()
    }

}


