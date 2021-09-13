package by.kos.rsnotesexample.utils

import by.kos.rsnotesexample.MainActivity
import by.kos.rsnotesexample.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository
const val ORDER_BY_TITLE = "name"
const val ORDER_BY_TEXT = "text"
const val ORDER_BY_PRIORITY = "priority"
const val TYPE_ROOM = "room"
const val TYPE_CURSOR = "cursor"
var CRITERIA = ORDER_BY_TITLE
var TYPE_DATASOURCE = TYPE_ROOM
const val PRIORITY_HIGHT = 1
const val PRIORITY_NORMAL = 2
const val PRIORITY_LOW = 3