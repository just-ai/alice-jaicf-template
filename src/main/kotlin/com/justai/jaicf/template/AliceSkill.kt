package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.catchall.CatchAllActivator
import com.justai.jaicf.activator.event.BaseEventActivator
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.context.manager.InMemoryBotContextManager
import com.justai.jaicf.context.manager.mongo.MongoBotContextManager
import com.justai.jaicf.template.scenario.MainScenario
import com.mongodb.client.MongoClients


private val contextManager = System.getenv("MONGODB_URI")?.let { url ->
    val client = MongoClients.create(url)
    MongoBotContextManager(client.getDatabase("jaicf").getCollection("contexts"))
} ?: InMemoryBotContextManager

val skill = BotEngine(
    scenario = MainScenario,
    defaultContextManager = contextManager,
    activators = arrayOf(
        RegexActivator,
        BaseEventActivator,
        CatchAllActivator
    )
)