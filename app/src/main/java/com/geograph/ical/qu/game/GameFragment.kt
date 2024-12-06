package com.geograph.ical.qu.game

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.*
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.geograph.ical.qu.R
import com.geograph.ical.qu.databinding.FragmentGameBinding
import kotlin.properties.Delegates


class GameFragment : Fragment() {

    lateinit var   a : ObjectAnimator;
    var progr = 0
    private var binding by Delegates.notNull<FragmentGameBinding>()
    lateinit var timer: CountDownTimer
    lateinit var quiz: Quiz
    var idYes: Int = 0
    var idNo: Int = 0
    var idHz: Int = 0
    var clicked = false
    var countR = 0

    var currentQuestionNumber = 0
    var currQuestion: Question? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root

    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.progressBar.max = 100
        binding.progressBar.progress = progr


        idYes = resources.getIdentifier("btn", "drawable", requireContext().packageName)
        idNo = resources.getIdentifier("btn1", "drawable", requireContext().packageName)
        idHz = resources.getIdentifier("btn2", "drawable", requireContext().packageName)


        progr = 0


        val i = requireArguments().getInt("id")
      // binding.image.setImageResource(resources.getIdentifier("i$i", "drawable", requireContext().packageName))

        quiz = Quiz()
        quiz.questions.shuffle()
        timerStart()




        binding.a1.setOnClickListener { click(1, binding.a1.text.toString(), it) }
        binding.a2.setOnClickListener { click(2, binding.a2.text.toString(), it) }
        binding.a3.setOnClickListener { click(3, binding.a3.text.toString(), it) }



    }

    private fun click(n: Int, answer: String, view: View) {

        a.cancel()

        a.removeAllListeners();
        timer.cancel()


        if (clicked) return
        clicked = true
        quiz.questions[currentQuestionNumber].isClicked = true
        currentQuestionNumber++

        if (currQuestion!!.rightAnswer == answer) {



            countR++
            binding.root.findViewWithTag<TextView>(n.toString()).setBackgroundResource(idYes)

        } else {

            for (i in 1..3) {
               if(binding.root.findViewWithTag<TextView>(i.toString()).text == currQuestion!!.rightAnswer){
                   binding.root.findViewWithTag<TextView>(i.toString()).setBackgroundResource(idYes)
               }
            }

            binding.root.findViewWithTag<TextView>(n.toString()).setBackgroundResource(idNo)
        }


        val handler = Handler()
        handler.postDelayed(Runnable { // Do something after 5s = 5000ms
            if (currentQuestionNumber < 10) {
                timerStart()
            } else{

                val bundle = bundleOf("count" to countR)
                requireView().findNavController().navigate(R.id.action_gameFragment_to_endFragment , bundle)
            }
        }, 1000)


    }





    fun timerStart() {
        progr =0
        binding.progressBar.progress = progr
        init(quiz.questions[currentQuestionNumber])

         a = ObjectAnimator.ofInt(  binding.progressBar, "progress", 0, 100).apply {
            duration = 5000 // время анимации в миллисекундах
            interpolator = LinearInterpolator() // интерполятор для плавности анимации
            start()
        }

        timer = object : CountDownTimer(5000.toLong(), 1000) {



            override fun onTick(p0: Long) {


            }

            override fun onFinish() {
                a.cancel()
                a.end()
                a.removeAllListeners();


                if (currentQuestionNumber < 9) {
                    if (!quiz.questions[currentQuestionNumber].isClicked) {
                        quiz.questions[currentQuestionNumber].isRight = false
                        currentQuestionNumber++
                        init(quiz.questions[currentQuestionNumber])

                        progr =0
                        binding.progressBar.progress = progr

                        timer.start()
                        ObjectAnimator.ofInt(  binding.progressBar, "progress", 0, 100).apply {
                            duration = 5000 // время анимации в миллисекундах
                            interpolator = LinearInterpolator() // интерполятор для плавности анимации
                            start()
                        }

                    }


                }


            }
        }.start()

    }

    fun init(current: Question) {
        clicked = false

        for (i in 1..3) {
            binding.root.findViewWithTag<TextView>(i.toString()).setBackgroundResource(idHz)
        }



        binding.question.text = current.text
        currQuestion = current
        val answers = mutableListOf<String>()
        current.noRightAnswers?.let { answers.addAll(it) }
        answers.add(current.rightAnswer)
        answers.shuffle()
        binding.a1.text = answers[0]
        binding.a2.text = answers[1]
        binding.a3.text = answers[2]



    }
}