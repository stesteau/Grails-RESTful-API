package com.moskiteau.rest

class Player {

    String firstName
    String lastName
    List positions

    static hasMany = [positions:Position]
    
    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
    }
}
