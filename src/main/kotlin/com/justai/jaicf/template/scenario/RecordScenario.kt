package com.justai.jaicf.template.scenario

import com.justai.jaicf.context.ActionContext
import com.justai.jaicf.model.scenario.Scenario

object RecordScenario: Scenario() {

    init {

        state("record", modal = true) {

            state("data") {
                activators {
                    regex("\\d+.*")
                }

                action {
                    reactions.goBack()
                }
            }

            fallback {
                reactions.sayRandom("Сколько-сколько?", "Повторите еще раз")
            }
        }
    }
}

fun ActionContext.record(message: String, callback: String) {
    reactions.say(message)
    reactions.changeState("/record", callback)
}