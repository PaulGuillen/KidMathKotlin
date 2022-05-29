package devpaul.business.kidmath.dashboard.operations.sum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import android.content.Intent
import android.content.pm.ActivityInfo
import android.util.Log
import devpaul.business.kidmath.R


class SumGameActivity : AppCompatActivity() {

    val TAG = "SumGame"

    var op1: Int? = null
    var op2: Int? = null
    var sum: Int? = null
    var sumOther: Int? = null

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

    var textlevel : TextView? = null


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum_game)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        op1 = 0
        op2 = 0
        sum = 0
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
                val incorrectAnswers = numberofQuestions - points
                Log.v(TAG, "incorrectAnswers : $incorrectAnswers ")
                Log.v(TAG, "numberQuestions : $numberofQuestions ")
                val level = intent.getStringExtra("level")
                val intent = Intent(this@SumGameActivity, GameOverSumaActivity::class.java)
                intent.putExtra("level", "Facil")
                intent.putExtra("points", points)
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
        op1 = random.nextInt(10,45)
        op2 = random.nextInt(10,45)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 4) break
            op1 = random.nextInt(10,45)
            op2 = random.nextInt(10,45)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    fun chooseAnswer(view: View) {
        val answer = (view as Button).text.toString().toInt()
        if (answer == sum) {
            points++
            tvResult!!.text = "Correcto!"
        } else {
            tvResult!!.text = "Incorrecto!"
        }
        tvPoints!!.text = "$points/$numberofQuestions"
        val level = intent.getStringExtra("level")
        if (level == "Facil") {
            generateQuestionEasy()
        }

        if (level == "Intermedio") {
            generateQuestionIntermediate()
        }

        if (level == "Avanzado") {
            generateQuestionAdvanced()
        }

        if (level == "Experto") {
            generateQuestionExpert()
        }

    }

    //SecondLevel
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
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                val intent = Intent(this@SumGameActivity, GameOverSumaActivity::class.java)
                intent.putExtra("level", "Intermedio")
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionIntermediate() {
        numberofQuestions++
        op1 = random.nextInt(35,75)
        op2 = random.nextInt(35,75)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 4) break
            op1 = random.nextInt(35,75)
            op2 = random.nextInt(35,75)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //ThirdLevel
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
                val level = intent.getStringExtra("level")
                val incorrectAnswers = numberofQuestions - points
                val intent = Intent(this@SumGameActivity, GameOverSumaActivity::class.java)
                intent.putExtra("points", points)
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                intent.putExtra("numberQuestions", numberofQuestions)
                intent.putExtra("level", "Avanzado")
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionAdvanced() {
        numberofQuestions++
        op1 = random.nextInt(65,120)
        op2 = random.nextInt(65,120)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 4) break
            op1 = random.nextInt(65,120)
            op2 = random.nextInt(65,120)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..3) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //FourthLevel
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
                val intent = Intent(this@SumGameActivity, GameOverSumaActivity::class.java)
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
        op1 = random.nextInt(120,323)
        op2 = random.nextInt(120,323)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 4) break
            op1 = random.nextInt(120,323)
            op2 = random.nextInt(120,323)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
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

