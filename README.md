# Шаблонный проект навыка Алисы на JAICF

Это готовый к использованию шаблон проекта навыка голосового ассистента Яндекс Алиса.
Написан с использованием [фреймворка JAICF](https://github.com/just-ai/jaicf-kotlin/tree/master/channels/yandex-alice) на языке [Kotlin](https://kotlinlang.org).

## Как использовать

Вы можете развернуть этот навык в облаке Heroku в один клик, а затем продолжить разработку и отладку на своем ПК.

### Развертывание на Heroku

1. <a href="https://oauth.yandex.ru/authorize?response_type=token&client_id=c473ca268cd749d3a8371351a8f2bcbd" target="_blank">
    Скопируйте ваш OAuth токен
</a>

2. Нажмите на кнопку ниже

<a href="https://heroku.com/deploy" target="_blank">
  <img src="https://www.herokucdn.com/deploy/button.svg" alt="Deploy">
</a><br/><br/>

Вебхук будет автоматически развернут в облаке Heroku, и вы получите рабочий сервер, который далее сможете обновлять (см ниже).

**При установке укажите ваш OAuth токен.**

### Тестирование

1. После развертывания вебхука нажмите на кнопку **View** и скопируйте URL. Это и есть ваш вебхук.
2. Создайте новый навык для Алисы в [Яндекс Диалогах](https://dialogs.yandex.ru/developer).
3. Укажите название навыка и URL вебхука, который вы скопировали (_остальные поля необязательны_).
4. Перейдите на вкладку _Тестирование_ - навык будет запущен автоматически.

### Локальная разработка и обновление сервера

#### Создание проекта

1. Установите [Heroku CLI](https://devcenter.heroku.com/articles/heroku-command-line).
2. Выполните следующие команды в терминале

```
heroku login
heroku git:clone -a <название вашего приложения на Heroku>
cd <название вашего приложения на Heroku>
git remote add origin https://github.com/just-ai/alice-jaicf-template
git pull origin master
```

3. Создайте новый проект в [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/) из исходных кодов (Project from Existing Sources), выберите Gradle из списка.

#### Разработка

Чтобы запустить вебхук локально, запустите `Webhook.kt`.
Сервер запускается на порту `8080`.

Чтобы разрабатывать навык, вам нужно получить публичный URL, который затем прописать в настройках вашего навыка в Яндекс Диалогах.
Для этого можно установить [ngrok](https://ngrok.com), а затем выполнить команду `ngrok http 8080` в терминале.
Таким образом все запросы от Алисы будут приходить на ваш локальный ПК, и вы сможете отлаживать сценарий навыка.

> Изучите [документацию JAICF](https://github.com/just-ai/jaicf-kotlin/tree/master/channels/yandex-alice), чтобы понимать, как разрабатывать навык для Алисы

#### Обновление сервера

Как только вы готовы обновить сервер, выполните следующие команды в терминале:

```
git add .
git commit -am "описание ваших изменений"
git push
```

Heroku автоматически соберет и обновит ваш сервер.

# Обратная связь

Если у вас возникли вопросы или проблемы, вы можете задать их в [Slack сообществе фреймворка JAICF](https://join.slack.com/t/jaicf/shared_invite/zt-clzasfyq-f4gv8hf3JHD4RmpMtrt0Aw) или [создать задачу](https://github.com/just-ai/alice-jaicf-template/issues) в этом репозитории.
