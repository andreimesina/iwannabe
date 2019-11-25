package com.trojans.iwannabe.careerpath

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.trojans.iwannabe.R
import com.trojans.iwannabe.data.CareerPathState

class CareerPathFragment : Fragment() {

    private lateinit var question: TextView
    private lateinit var firstBtn: Button
    private lateinit var secondBtn: Button
    private lateinit var thirdBtn: Button
    private lateinit var tick: ImageView

    private val onClickListener = View.OnClickListener {
        when (currentCareerPathState) {
            CareerPathState.Career -> setHighschoolTexts()
            CareerPathState.Highschool -> setUniversityTexts()
            CareerPathState.University -> setFinishTexts()
        }
    }

    private var currentCareerPathState = CareerPathState.Career

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_career_path, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question = view.findViewById(R.id.textView_career_path_question)
        firstBtn = view.findViewById(R.id.textView_engineer)
        secondBtn = view.findViewById(R.id.textView_vet)
        thirdBtn = view.findViewById(R.id.textView_firefighter)
        tick = view.findViewById(R.id.imageView_tick)

        firstBtn.setOnClickListener(onClickListener)
        secondBtn.setOnClickListener(onClickListener)
        thirdBtn.setOnClickListener(onClickListener)
    }

    private fun setHighschoolTexts() {
        question.text =
            "Choose a highschool profile from the following to find out what's the next step:"
        firstBtn.text = "Mathematics and CS (60%)"
        secondBtn.text = "Natural Sciences (30%)"
        thirdBtn.text = "Sports and PE (10%)"

        currentCareerPathState = CareerPathState.Highschool
    }

    private fun setUniversityTexts() {
        question.text = "Choose a university from the following:"
        firstBtn.text = "Polytechnic (60%)"
        secondBtn.text = "Mathematics and Informatics (30%)"
        thirdBtn.text = "Economy (10%)"

        currentCareerPathState = CareerPathState.University
    }

    private fun setFinishTexts() {
        question.text =
            "Congratulations! You have been matched with the groups that fit your career path the best!"
        firstBtn.visibility = View.GONE
        secondBtn.visibility = View.GONE
        thirdBtn.visibility = View.GONE
        tick.visibility = View.VISIBLE
    }
}
