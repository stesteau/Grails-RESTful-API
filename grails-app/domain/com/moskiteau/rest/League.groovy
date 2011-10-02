package com.moskiteau.rest

class League {

    String name
    def teams

    static hasMany = [teams:Team]    
    static constraints = {
        name(blank:false)
    }
}
