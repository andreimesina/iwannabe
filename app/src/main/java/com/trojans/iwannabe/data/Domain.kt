package com.trojans.iwannabe.data

data class Domain(val name: String)

enum class Domains(val domainName: String) {
    Engineering("Engineering"),
    Mathematics("Mathematics"),
    Medicine("Medicine"),
    Sports("Sports"),
    Literature("Literature"),
    Physics("Physics"),
    Programming("Programming"),
    Acting("Acting"),
    Music("Music"),
    IdontKnow("I don't know")
}

enum class QuestionsState {
    Domains,
    Hobbies,
    Activity
}

enum class CareerPathState {
    Career,
    Highschool,
    University
}

fun from(name: String): Domains {
    return Domains.values().first { it.domainName == name }
}