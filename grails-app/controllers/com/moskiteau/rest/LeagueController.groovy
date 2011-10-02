package com.moskiteau.rest

import grails.converters.XML

class LeagueController {

    def index() {
        String response = ""
        try {
            def leagues = League.findAll()
            response = leagues as XML
        } catch(Exception e) {
            log.error(e.message)
            render(status:412,text:e.message,contentType:"text/xml",encoding:"UTF-8")
        }
        withFormat {
            xml {
                render(status:200,text:response,contentType:"text/xml",encoding:"UTF-8")
            }
        }
    }
}
