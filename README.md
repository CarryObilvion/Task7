# Назначение программы

Данная программа синхронизирует работы трех компонентов. При запуске приложения включается обратный отсчет в течении которого будет включен музыкальный клип и показано изображение. В конце отсчета таймер будет остановлен.

# Область применения программы

Шаблон «наблюдатель» применяется в тех случаях, когда система обладает следующими свойствами:

* существует как минимум один объект, рассылающий сообщения;
* имеется не менее одного получателя сообщений, причём их количество и состав могут изменяться во время работы приложения;
* позволяет избежать сильного зацепления взаимодействующих классов.

Данный шаблон часто применяют в ситуациях, в которых отправителя сообщений не интересует, что делают получатели с предоставленной им информацией.

# Описание проекта

Проект представляет собой оконное приложение. Изначальный вид проекта - AnchorPane с разположенными на ней 3 label, каждая из которых отображает время:
1-я label отображает время до конца работы приложения
2-я label время до начала музыкального клипа
3-я label время до показа изображения

# Паттерн

Наблюдатель (англ. Observer) — поведенческий шаблон проектирования. Реализует у класса механизм, который позволяет объекту этого класса получать оповещения об изменении состояния других объектов и тем самым наблюдать за ними.

# Реализация проекта

![Task7](https://user-images.githubusercontent.com/80450495/114278316-ea512f80-9a37-11eb-84a2-738be050fac8.png)

