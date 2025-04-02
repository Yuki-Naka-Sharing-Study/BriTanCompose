package com.example.britan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    val questions = listOf(
        "Color" to "Colour",
        "Favorite" to "Favourite",
        "Honor" to "Honour",
        "Realize" to "Realise",
        "Apologize" to "Apologise",
        "Traveling" to "Travelling",
        "Canceled" to "Cancelled",
        "Modeled" to "Modelled",
        "Theater" to "Theatre",
        "Center" to "Centre",
        "Meter" to "Metre",
        "Liter" to "Litre",
        "Defense" to "Defence",
        "Offense" to "Offence",
        "License" to "Licence",
        "Jewelry" to "Jewellery",
        "Program" to "Programme",
        "Catalog" to "Catalogue",
        "Dialogue" to "Dialog",
        "Check" to "Cheque",
        "Gray" to "Grey",
        "Plow" to "Plough",
        "Tire" to "Tyre",
        "Aluminum" to "Aluminium",
        "Curb" to "Kerb",
        "Draft" to "Draught",
        "Mustache" to "Moustache",
        "Pajamas" to "Pyjamas",
        "Diaper" to "Nappy",
        "Soccer" to "Football",
        "Truck" to "Lorry",
        "Elevator" to "Lift",
        "Apartment" to "Flat",
        "Faucet" to "Tap",
        "Flashlight" to "Torch",
        "Trash can" to "Bin",
        "Cookie" to "Biscuit",
        "French fries" to "Chips",
        "Chips" to "Crisps",
        "Eggplant" to "Aubergine",
        "Zucchini" to "Courgette",
        "Gasoline" to "Petrol",
        "Hood" to "Bonnet",
        "Trunk" to "Boot",
        "Line" to "Queue",
        "Fall" to "Autumn",
        "Candy" to "Sweets",
        "Math" to "Maths",
        "Movie" to "Film",
        "Railroad" to "Railway",
        "Subway" to "Underground",
        "Vacation" to "Holiday",
        "Store" to "Shop",
        "Bill" to "Note",
        "Bill (restaurant)" to "Check",
        "Soccer field" to "Football pitch",
        "Overpass" to "Flyover",
        "Intersection" to "Junction",
        "Round trip" to "Return (ticket)",
        "One-way ticket" to "Single (ticket)",
        "Period" to "Full stop",
        "Eraser" to "Rubber",
        "Band-Aid" to "Plaster",
        "Drugstore" to "Chemist",
        "Stroller" to "Pushchair",
        "Yard" to "Garden",
        "Mailbox" to "Postbox",
        "Mail" to "Post",
        "Antenna" to "Aerial",
        "Sidewalk" to "Pavement",
        "License plate" to "Number plate",
        "Public school" to "State school",
        "Private school" to "Public school",
        "Principal" to "Headteacher",
        "Garbage" to "Rubbish",
        "Janitor" to "Caretaker",
        "Zip code" to "Postcode",
        "Cellphone" to "Mobile phone",
        "Call" to "Ring",
        "Rent" to "Hire",
        "Resume" to "CV",
        "Pants" to "Trousers",
        "Vest" to "Waistcoat",
        "Sweater" to "Jumper",
        "Undershirt" to "Vest",
        "Mailman" to "Postman",
        "Raincoat" to "Mackintosh",
        "Scotch tape" to "Sellotape",
        "Hooded sweatshirt" to "Hoodie",
        "Turn signal" to "Indicator"
    )

    var correctAnswers by mutableStateOf<List<Pair<String, String>>>(emptyList())
        private set
    var wrongAnswers by mutableStateOf<List<Pair<String, String>>>(emptyList())
        private set

    fun submitAnswer(question: String, userAnswer: String, correctAnswer: String) {
        if (userAnswer.equals(correctAnswer, ignoreCase = true)) {
            correctAnswers = correctAnswers + (question to correctAnswer)
        } else {
            wrongAnswers = wrongAnswers + (question to correctAnswer)
        }
    }

    fun calculateAccuracy(): Float {
        val total = correctAnswers.size + wrongAnswers.size
        return if (total == 0) 0f else (correctAnswers.size.toFloat() / total) * 100
    }
}
