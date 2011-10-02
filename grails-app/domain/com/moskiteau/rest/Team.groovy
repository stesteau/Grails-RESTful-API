package com.moskiteau.rest

class Team {

    String name
    String slogan
    List players

    static hasMany = [players:Player]
    static constraints = {
        name(blank:false)
        slogan(blank:false)
    }

}
