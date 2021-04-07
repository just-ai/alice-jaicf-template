package com.justai.jaicf.template.scenario

import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.channel.yandexalice.model.AliceEvent
import com.justai.jaicf.channel.yandexalice.alice

val MainScenario = Scenario {
    append(RecordScenario)

    state("main") {
        activators {
            event(AliceEvent.START)
        }

        action {
            reactions.run {
                say("Управдом слушает. Вы хотите сообщить ваши показания счетчиков?")
                buttons("Да", "Нет")
                alice?.image(
                    "https://i.imgur.com/SUSGpqG.jpg",
                    "Управдом слушает",
                    "Хотите сообщить ваши показания счетчиков?"
                )
            }
        }
    }

    state("yes") {
        activators {
            regex("да|хочу")
        }

        action {
            record("Сколько вы потратили холодной воды?", "warm")
        }

        state("warm") {

            action {
                record("Сколько ушло горячей?", "done")
            }

            state("done") {
                action {
                    reactions.say("Записала ваши показания. Ждите квитанцию на оплату.")
                    reactions.alice?.endSession()
                }
            }
        }
    }

    state("no") {
        activators {
            regex("нет|не хочу")
        }

        action {
            reactions.say("Тогда не отвлекайте меня от работы. До свидания!")
            reactions.alice?.endSession()
        }
    }

    fallback {
        reactions.say("Не тратьте мое время зря. Вы хотите сообщить показания счетчиков?")
        reactions.buttons("Да", "Нет")
    }
}