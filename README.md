# Travel Telegram Bot

## Technology stack

+ Java 11
+ SpringBoot, SpringMVC, SpringData
+ Hibernate
+ H2
+ Maven

## Task

Необходимо создать web приложение по управлению собственным туристическим телеграм ботом.
1) Телеграм бот выдает пользователю справочную информацию о введенном городе. Например, пользователь вводит: «Москва», чат-бот отвечает: «Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))».
2) Данные о городах должны храниться в базе данных.
3) Управлять данными о городах (добавлять новые города и информацию о них, изменять и удалять любую информацию) необходимо через REST WebService.

Используемые технологии: SpringBoot, SpringMVC, SpringData, Hibernate, Java не ниже 1.8. Для сборки проекта использовать Maven.

## Install

Clone project:
```
git clone https://github.com/alishevich/travel-telegrambot.git
```
Deploy:

```
$ docker build -t travel .
```
```
$ docker run -p 8080:8080 travel
```

bot user name : @travel_information_bot

token : 1808216616:AAH4drZ-xcCGbwLFTnZ0grwovjTyESOGjSc

## API
Swagger documentation will be available at http://localhost:8080/swagger-ui.html



