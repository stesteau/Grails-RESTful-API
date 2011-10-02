
import com.moskiteau.rest.*

import grails.converters.XML
import com.moskiteau.converters.marshaller.*

class BootStrap {

    def init = { servletContext ->

        XML.registerObjectMarshaller(new CustomObjectMarshaller())

        League league = new League(name:"National Hockey League")
        
        Team a = new Team(name:"Canadien", slogan:"Nos bras meurtris vous tendent le flambeau, À vous de le tenir bien haut")
        Team b = new Team(name:"Bruins", slogan:"Habs own us")

        Player gomez = new Player(firstName:"Scott", lastName:"Gomez")
        Player gionta = new Player(firstName:"Scott", lastName:"Gomez")
        Player chara = new Player(firstName:"Zdeno", lastName:"Chára")

        Position center = new Position(name:"Center")
        Position leftWing = new Position(name:"Left Wing")
        Position defense = new Position(name:"Defense")

        chara.positions = [defense]
        chara.save()

        gomez.positions = [center, leftWing]
        gomez.save()

        gionta.positions = [leftWing]
        gionta.save()

        a.players = [gomez,gionta]
        a.save()

        b.players = [chara]
        b.save()

        league.teams = [a,b]
        league.save()

    }

    def destroy = {
    }
    
}
