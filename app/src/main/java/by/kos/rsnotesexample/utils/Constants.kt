package by.kos.rsnotesexample.utils

import by.kos.rsnotesexample.MainActivity
import by.kos.rsnotesexample.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository
const val ORDER_BY_TITLE = "name"
const val ORDER_BY_TEXT = "text"
const val ORDER_BY_PRIORITY = "priority"
var CRITERIA = ORDER_BY_TITLE
const val PRIORITY_HIGHT = 1
const val PRIORITY_NORMAL = 2
const val PRIORITY_LOW = 3