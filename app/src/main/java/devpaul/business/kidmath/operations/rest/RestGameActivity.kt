package devpaul.business.kidmath.operations.rest

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import devpaul.business.kidmath.R
import devpaul.business.kidmath.operations.sum.GameOverSumaActivity
import kotlin.random.Random

class RestGameActivity : AppCompatActivity() {

    var op1: Int? = null
    var op2: Int? = null
    var rest: Int? = null
    var restOther: Int? = null

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

    var points =0
    var numberofQuestions = 0
    var random: Random = Random

    var textlevel : TextView? =null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_game)

        //desactivar rotacion pantalla
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        op1 = 0
        op2 = 0
        rest = 0
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
        millisUntilFinished = 30100
        incorrectAnswers = ArrayList()

        val level = intent.getStringExtra("level")
        if (level == "one") {
            firstLevelGame()
            textlevel?.text = "Nivel 1"
        }
        if (level == "two") {
            secondLevelGame()
            textlevel?.text = "Nivel 2"
        }
        if (level == "third") {
            thirdLevelGame()
            textlevel?.text = "Nivel 3"
        }

        if (level == "four") {
            fourthlevelgame()
            textlevel?.text = "Nivel 4"
        }

        if (level == "five") {
            fifthlevelgame()
            textlevel?.text = "Nivel 5"
        }
        if (level == "six") {
            sixlevelgame()
            textlevel?.text = "Nivel 6"
        }



    }

    @SuppressLint("SetTextI18n")
    private fun firstLevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion() {
        numberofQuestions++
        op1 = random.nextInt(5,10)
        op2 = random.nextInt(1,4)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(1,15)
            op2 = random.nextInt(1,5)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    fun chooseAnswer(view: View) {
        val answer = (view as Button).text.toString().toInt()
        if (answer == rest) {
            points++
            tvResult!!.text = "Correcto!"
        } else {
            tvResult!!.text = "Incorrecto!"
        }
        tvPoints!!.text = "$points/$numberofQuestions"

        val level = intent.getStringExtra("level")
        if (level == "one"){
            generateQuestion()
        }

        if ( level == "two"){
            generateQuestion2()
        }

        if ( level == "third"){
            generateQuestion3()
        }

        if (level == "four") {
            generateQuestion4()
        }

        if (level == "five") {
            generateQuestion5()
        }
        if (level == "six") {
            generateQuestion6()
        }

    }

    //Second level Game
    @SuppressLint("SetTextI18n")
    private fun secondLevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion2()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion2() {
        numberofQuestions++
        op1 = random.nextInt(15,30)
        op2 = random.nextInt(10,14)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(15,30)
            op2 = random.nextInt(10,14)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Third level Game
    @SuppressLint("SetTextI18n")
    private fun thirdLevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion3()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion3() {
        numberofQuestions++
        op1 = random.nextInt(25,40)
        op2 = random.nextInt(10,24)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(25,40)
            op2 = random.nextInt(10,24)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Fourth level Game
    @SuppressLint("SetTextI18n")
    private fun fourthlevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion4()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion4() {
        numberofQuestions++
        op1 = random.nextInt(35,50)
        op2 = random.nextInt(15,34)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(35,50)
            op2 = random.nextInt(15,34)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Fifth level Game
    @SuppressLint("SetTextI18n")
    private fun fifthlevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion5()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion5() {
        numberofQuestions++
        op1 = random.nextInt(45,60)
        op2 = random.nextInt(20,44)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(45,60)
            op2 = random.nextInt(20,44)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //six level Gam
    @SuppressLint("SetTextI18n")
    private fun sixlevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestion6()
        countDownTimer = object : CountDownTimer(millisUntilFinished!!, 1000) {
            override fun onTick(time: Long) {
                tvTimer?.text = "" + (time / 1000) + "s"
            }

            override fun onFinish() {
                btn0?.isClickable = false
                btn1?.isClickable = false
                btn2?.isClickable = false
                btn3?.isClickable = false
                val intent = Intent(this@RestGameActivity, GameOverRestaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion6() {
        numberofQuestions++
        op1 = random.nextInt(55,70)
        op2 = random.nextInt(35,54)
        rest = op1!! - op2!!
        tvSum?.text = "$op1 - $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + rest
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(55,70)
            op2 = random.nextInt(35,54)
            restOther = op1!! - op2!!
            if (restOther == rest) {
                continue
            }
            incorrectAnswers?.add(restOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition){
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