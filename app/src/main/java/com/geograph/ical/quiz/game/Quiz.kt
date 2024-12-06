package com.geograph.ical.quiz.game

class Quiz() {

    var questions = emptyList<Question>().toMutableList()

    init {
        initQuestions()

    }




    private fun initQuestions() {
          questions = mutableListOf(
            Question(
                "Longest river in the world?",
                "The Nile",
                listOf("The Amazon", "The Mississippi")
            ),
            Question(
                "Which river runs through the Grand Canyon?",
                "Colorado River",
                listOf("Missouri River", "Hudson River")
            ),
            Question(
                "River that flows through London?",
                "Thames River",
                listOf("Seine River", "Danube River")
            ),
            Question(
                "The second-longest river in Europe?",
                "Danube River",
                listOf("Volga River", "Elbe River")
            ),
            Question(
                "Which river forms part of the border between the United States and Mexico?",
                "Rio Grande",
                listOf("Mississippi River", "Colorado River")
            ),
            Question(
                "River that runs through Egypt and Sudan?",
                "Nile River",
                listOf("Euphrates River", "Tigris River")
            ),
            Question(
                "River known as the 'Cradle of Civilization'?",
                "Tigris River",
                listOf("Indus River", "Ganges River")
            ),
            Question(
                "River that forms the border between the United States and Canada in the Pacific Northwest?",
                "Columbia River",
                listOf("Missouri River", "Mississippi River")
            ),
            Question(
                "The longest river in Australia?",
                "Murray-Darling River",
                listOf("Amazon River", "Congo River")
            ),
            Question(
                "River that flows through Paris?",
                "Seine River",
                listOf("Thames River", "Rhone River")
            )
        )
        questions.add(
            Question(
                "Largest river in the world?",
                "The Nile",
                listOf("The Amazon", "The Mississippi")
            )
        )

        questions.add(
            Question(
                "Country known as the Land of the Rising Sun?",
                "Japan",
                listOf("China", "South Korea")
            )
        )

        questions.add(
            Question(
                "Capital of France?",
                "Paris",
                listOf("Madrid", "Rome")
            )
        )

        questions.add(
            Question(
                "Longest mountain range on Earth?",
                "The Andes",
                listOf("The Himalayas", "The Rockies")
            )
        )

        questions.add(
            Question(
                "Deepest point in the ocean?",
                "Mariana Trench",
                listOf("Sunda Trench", "Tasman Basin")
            )
        )

        questions.add(
            Question(
                "The coldest continent?",
                "Antarctica",
                listOf("Arctic", "Asia")
            )
        )

        questions.add(
            Question(
                "The world's largest desert?",
                "The Sahara Desert",
                listOf("Gobi Desert", "Kalahari Desert")
            )
        )

        questions.add(
            Question(
                "Country known as the Land of Fire and Ice?",
                "Iceland",
                listOf("Greenland", "Ireland")
            )
        )

        questions.add(
            Question(
                "Largest country in Africa?",
                "Algeria",
                listOf("Nigeria", "South Africa")
            )
        )

        questions.add(
            Question(
                "Capital of Brazil?",
                "Brasília",
                listOf("Rio de Janeiro", "São Paulo")
            )
        )


        questions.shuffle()
    }



}

class Question(val text: String, val rightAnswer: String, var noRightAnswers: List<String>? = null) {
    var isClicked = false
    var isRight: Boolean? = false
}
