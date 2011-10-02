package com.moskiteau.rest

import grails.converters.XML

class TeamController {

    def teamService
    
    def index() {
        String response = ""
        try {
            def teams = Team.findAll()
            XML.use("deep"){ response = teams as XML }            
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

    def show() {
        String response = ""
        try {
            def team = Team.get(params.id) as XML
            response = teams as XML
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

    def save = {
        if(request.format == 'xml') {
            /**             
             * @See http://en.wikipedia.org/wiki/Byte_order_mark
             */
            def str = request.reader.text.trim().replaceFirst("^([\\W]+)<","<");
            try {
                println "WTF?"
                Team team = teamService.parse(str)
                team.save()
                String response = team as XML
                render(status:201, text:response, contentType:"text/xml", encoding:"UTF-8")            
            } catch(Exception e) {
                log.error(e.message)
                render(status:412,text:e.message,contentType:"text/xml",encoding:"UTF-8")
            }
        }
    }
}
