package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Answer
import no.nav.rapid.Assessment
import no.nav.rapid.Question



/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)
        if (question.category == "arithmetic") handleQ2(question)
        if (question.category == "NAV") handleQ3(question)


    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    override fun handle(answer: Answer) {
        logger.log(answer)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleRegisterTeam(question: Question) {
        //TODO("Her må du skrive kode ;)")
        answer(question.category, questionId = question.id(), "fafafa")
    }

    private fun handleQ2(question: Question) {
        //TODO("Her må du skrive kode ;)")
        val regex = """(\d+) (.) (\d+)""".toRegex()
        val matchResult = regex.find(question.question)!!
        val (n1, sign, n2) = matchResult.destructured

        if (sign == "*") {
            answer(question.category, questionId = question.id(), (n1.toInt() * n2.toInt()).toString())
        }
        if (sign == "-") {
            answer(question.category, questionId = question.id(), (n1.toInt() - n2.toInt()).toString())
        }
        if (sign == "+") {
            answer(question.category, questionId = question.id(), (n1.toInt() + n2.toInt()).toString())
        }
        if (sign == "/") {
            answer(question.category, questionId = question.id(), (n1.toInt() / n2.toInt()).toString())
        }
    }

    private fun handleQ3(question: Question) {
        //TODO("Her må du skrive kode ;)")
        if (question.question == "På hvilken nettside finner man informasjon om rekruttering til NAV IT?"){
            answer(question.category, questionId = question.id(), "https://www.detsombetyrnoe.no\n")
        }

        if (question.question == "Hva heter designsystemet vårt?"){
            answer(question.category, questionId = question.id(), "Aksel")
        }
        if (question.question == "Hvor mye er 1G per 1. mai 2023?"){
            answer(question.category, questionId = question.id(), "118620")
        }
        if (question.question == "Hvor har vi kontor?"){
            answer(question.category, questionId = question.id(), "Fyrstikkalléen 1")
        }
        if (question.question == "Hva heter NAV-direktøren?"){
            answer(question.category, questionId = question.id(), "Hans Christian Holte")
        }

        if (question.question == "Hva heter applikasjonsplattformen til NAV?"){
            answer(question.category, questionId = question.id(), "nais")
        }


    }



}