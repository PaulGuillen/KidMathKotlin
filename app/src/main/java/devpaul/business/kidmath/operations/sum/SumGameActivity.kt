package devpaul.business.kidmath.operations.sum

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
import devpaul.business.kidmath.R


class SumGameActivity : AppCompatActivity() {

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
        millisUntilFinished = 30100

        val level = intent.getStringExtra("level")
        if (level == "one") {
            fistlevelGame()
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
            fouthlevelGame()
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
    private fun fistlevelGame() {

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
                val intent = Intent(this@SumGameActivity, GameOverSumaActivity::class.java)
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestion() {
        numberofQuestions++
        op1 = random.nextInt(10)
        op2 = random.nextInt(10)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(10)
            op2 = random.nextInt(10)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
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
        if (level == "one"){
            generateQuestion()
        }

        if ( level == "two"){
            generateQuestionLevel2()
        }

        if ( level == "third"){
            generateQuestionLevel3()
        }

        if (level == "four") {
            generateQuestionLevel4()
        }

        if (level == "five") {
            generateQuestionLevel5()
        }
        if (level == "six") {
            generateQuestionLevel6()
        }

    }

    //Segundo Nivel
    @SuppressLint("SetTextI18n")
    private fun secondLevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionLevel2()
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
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionLevel2() {
        numberofQuestions++
        op1 = random.nextInt(10,20)
        op2 = random.nextInt(10,20)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(10,20)
            op2 = random.nextInt(10,20)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Tercer Nivel
    @SuppressLint("SetTextI18n")
    private fun thirdLevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionLevel3()
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
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionLevel3() {
        numberofQuestions++
        op1 = random.nextInt(10,30)
        op2 = random.nextInt(10,30)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(10,30)
            op2 = random.nextInt(10,30)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Cuarto Nivel
    @SuppressLint("SetTextI18n")
    private fun fouthlevelGame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionLevel4()
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
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionLevel4() {
        numberofQuestions++
        op1 = random.nextInt(20,40)
        op2 = random.nextInt(20,40)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(20,40)
            op2 = random.nextInt(20,40)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Quinto Nivel
    @SuppressLint("SetTextI18n")
    private fun fifthlevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionLevel5()
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
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionLevel5() {
        numberofQuestions++
        op1 = random.nextInt(20,50)
        op2 = random.nextInt(20,50)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(20,50)
            op2 = random.nextInt(20,50)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
            if (i == correctAnswerPosition) {
                continue
            }
            (findViewById<View>(btnIds[i]) as Button).text = "" + incorrectAnswers!![i]
        }
        incorrectAnswers!!.clear()
    }

    //Sexto Nivel
    @SuppressLint("SetTextI18n")
    private fun sixlevelgame() {

        tvTimer?.text = "" + (millisUntilFinished!! / 1000) + "s"
        tvPoints?.text = "$points/$numberofQuestions"
        generateQuestionLevel6()
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
                intent.putExtra("points", points)
                startActivity(intent)
                finish()
            }

        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun generateQuestionLevel6() {
        numberofQuestions++
        op1 = random.nextInt(50,80)
        op2 = random.nextInt(50,80)
        sum = op1!! + op2!!
        tvSum?.text = "$op1 + $op2 = "
        correctAnswerPosition = random.nextInt(4)
        (findViewById<View>(btnIds[correctAnswerPosition]) as Button).text = "" + sum
        while (true) {
            if (incorrectAnswers!!.size > 3) break
            op1 = random.nextInt(50,80)
            op2 = random.nextInt(50,80)
            sumOther = op1!! + op2!!
            if (sumOther == sum) {
                continue
            }
            incorrectAnswers?.add(sumOther!!)
        }

        for (i in 0..2) {
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

