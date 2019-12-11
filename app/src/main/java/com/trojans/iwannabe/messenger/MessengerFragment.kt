package com.trojans.iwannabe.messenger

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.firebase.client.ChildEventListener
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.trojans.iwannabe.R
import java.util.*


class MessengerFragment : Fragment() {
    private var layout: LinearLayout? = null
    private var sendButton: ImageView? = null
    private var messageArea: EditText? = null
    private var scrollView: ScrollView? = null
    private var reference1: Firebase? = null
    private var reference2: Firebase? = null
    private val bot = Chatbot()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout = view.findViewById(R.id.layout1)
        sendButton = view.findViewById(R.id.sendButton)
        messageArea = view.findViewById(R.id.messageArea)
        scrollView = view.findViewById(R.id.scrollView)

        Firebase.setAndroidContext(view.context)
        reference1 =
            Firebase("https://chatapp-60323.firebaseio.com/messages/" + UserDetails.username + "_" + UserDetails.chatWith)
        reference2 =
            Firebase("https://chatapp-60323.firebaseio.com/messages/" + UserDetails.chatWith + "_" + UserDetails.username)

        bot.read("")
        val answer = bot.run()
        val map = HashMap<String, String>()
        map["message"] = UserDetails.chatWith + ": " + answer
        map["user"] = UserDetails.chatWith

        sendButton!!.setOnClickListener {
            val messageText = messageArea!!.text.toString()

            if (messageText != "") {
                val map = HashMap<String, String>()
                map["message"] = UserDetails.username + ": " + messageText
                map["user"] = UserDetails.username

                reference1!!.push().setValue(map)
                reference2!!.push().setValue(map)
                bot.read(messageText)
                val answer = bot.run()
                map["message"] = UserDetails.chatWith + ": " + answer
                map["user"] = UserDetails.chatWith

                reference1!!.push().setValue(map)
                reference2!!.push().setValue(map)
                messageArea!!.setText("")
            }
        }

        reference1!!.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                val messageMap = dataSnapshot.getValue(Map::class.java)
                val message = messageMap["message"]!!.toString()
                val userName = messageMap["user"]!!.toString()

                if (userName == UserDetails.username) {
                    addMessageBox(message.replaceFirst(": ", ""), 2)
                } else {
                    addMessageBox(message, 1)
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String) {

            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {

            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String) {

            }

            override fun onCancelled(firebaseError: FirebaseError) {

            }
        })
    }

    private fun addMessageBox(message: String, type: Int) {
        val textView = TextView(this.context)
        textView.text = message

        val lp2 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lp2.weight = 7.0f
        lp2.topMargin = 8

        if (type == 1) {
            lp2.gravity = Gravity.START
            textView.setPadding(16, 16, 16, 16)
            textView.setBackgroundResource(R.drawable.bubble_in)
            textView.setTextColor(resources.getColor(R.color.colorWhite))
        } else {
            lp2.gravity = Gravity.END
            textView.setPadding(16, 16, 16, 16)
            textView.setBackgroundResource(R.drawable.bubble_out)
            textView.setTextColor(resources.getColor(R.color.colorWhite))
        }

        textView.layoutParams = lp2
        layout!!.addView(textView)
        scrollView!!.fullScroll(View.FOCUS_DOWN)
    }
}