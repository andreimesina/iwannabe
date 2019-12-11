package com.trojans.iwannabe.messenger

class Chatbot {
    private lateinit var userMessage: String
    private lateinit var chatbotMessage: String
    private var state: Int = 0

    fun read(msg: String) {
        userMessage = msg
        userMessage = userMessage.replace("[^a-zA-Z ]".toRegex(), "").toLowerCase()
    }

    private fun write(message: String): String {
        ++state
        chatbotMessage = message
        return chatbotMessage
    }

    fun run() = when (state) {
        0 -> write("Hey there!")

        1 -> if (!this.userMessage.contains("hello") && !this.userMessage.contains("hi")) {
            write("Aren't you going to greet me?!")
        } else {
            write("Nice to meet you")
        }

        2 -> write("Wanna hear a knock knock joke?")

        3 -> if (!this.userMessage.contains("yes") && !this.userMessage.contains("sure")) {
            write("Too bad! Knock! Knock!")
        } else {
            write("Knock! Knock!")
        }

        4 -> if (this.userMessage.contains("who") && this.userMessage.contains("there")) {
            write("No one")
        } else {
            write("You ruined my joke")
        }

        5 -> write("...")

        else -> ""
    }
}
