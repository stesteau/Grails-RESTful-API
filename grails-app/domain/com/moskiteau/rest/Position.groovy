package com.moskiteau.rest

class Position {

    String name
    
    static constraints = {
        name(blank:false)
    }
}
