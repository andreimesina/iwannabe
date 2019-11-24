package com.trojans.iwannabe.onboarding

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewAnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.trojans.iwannabe.R
import com.trojans.iwannabe.auth.LoginActivity
import com.trojans.iwannabe.data.Domain
import com.trojans.iwannabe.data.QuestionsState
import com.trojans.iwannabe.setString

class OnboardingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bubblesAdapter: BubblesAdapter

    private var bubblesList = mutableListOf<Domain>()

    private lateinit var logo: View
    private lateinit var question: TextView
    private lateinit var nextBtn: TextView

    private var currentQuestionsState = QuestionsState.Domains

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        logo = findViewById(R.id.imageView_logo)
        question = findViewById(R.id.textView_question)
        nextBtn = findViewById(R.id.textView_nextQuestion)
        recyclerView = findViewById(R.id.recyclerView)

        nextBtn.setOnClickListener {
            when (currentQuestionsState) {
                QuestionsState.Domains -> {
                    mockHobbiesList()
                    showBubbles(0)
                    currentQuestionsState = QuestionsState.Hobbies
                }
                QuestionsState.Hobbies -> {
                    mockIsActiveList()
                    showBubbles(0)
                    currentQuestionsState = QuestionsState.Activity
                }
                QuestionsState.Activity -> {
                    setString(this, "activity", bubblesAdapter.selectedOptions.toString())
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        triggerLogoAnimation()
        mockBubblesList()
        showBubbles(3500)
    }

    private fun showBubbles(delay: Long) {
        logo.postDelayed({
            logo.visibility = GONE
            question.visibility = VISIBLE
            nextBtn.visibility = VISIBLE

            bubblesAdapter = BubblesAdapter(this, bubblesList)
            recyclerView.apply {
                adapter = bubblesAdapter
            }
        }, delay)
    }

    private fun mockBubblesList() {
        bubblesList.add(Domain("I don't know"))
        bubblesList.add(Domain("Engineering"))
        bubblesList.add(Domain("Medicine"))
        bubblesList.add(Domain("Sports"))
        bubblesList.add(Domain("Mathematics"))
        bubblesList.add(Domain("Literature"))
        bubblesList.add(Domain("Physics"))
        bubblesList.add(Domain("Programming"))
        bubblesList.add(Domain("Acting"))
        bubblesList.add(Domain("Music"))
    }

    private fun mockHobbiesList() {
        question.text = "Which are your favourite hobbies?"
        bubblesList.clear()
        setString(this, "domains", bubblesAdapter.selectedOptions.toString())

        bubblesList.add(Domain("Sports"))
        bubblesList.add(Domain("Video games"))
        bubblesList.add(Domain("Cooking"))
        bubblesList.add(Domain("Reading books"))
        bubblesList.add(Domain("Programming"))
        bubblesList.add(Domain("Music"))
        bubblesList.add(Domain("Party"))
    }

    private fun mockIsActiveList() {
        question.text = "How active are you?"
        bubblesList.clear()
        setString(this, "hobbies", bubblesAdapter.selectedOptions.toString())

        bubblesList.add(Domain("A little"))
        bubblesList.add(Domain("Medium"))
        bubblesList.add(Domain("Very active!"))
    }

    private fun triggerLogoAnimation() {
        logo.post {
            // Check if the runtime version is at least Lollipop
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // get the center for the clipping circle
                val cx = logo.width / 2
                val cy = logo.height / 2

                // get the final radius for the clipping circle
                val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

                // create the animator for this view (the start radius is zero)
                val anim = ViewAnimationUtils.createCircularReveal(logo, cx, cy, 0f, finalRadius)
                // make the view visible and start the animation
                logo.visibility = VISIBLE
                anim.duration = 2500
                anim.start()
            } else {
                // set the view to invisible without a circular reveal animation below Lollipop
                logo.visibility = View.INVISIBLE
            }
        }

        logo.postDelayed({
            val fadeOut = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f)
            fadeOut.duration = 2500
            fadeOut.start()
        }, 2000)
    }

}
