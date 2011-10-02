package com.moskiteau.rest

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.DomDriver;

class TeamService {

    def parse(String str) {
        //No need to add every alias, just the collections
        Team team = new Team()
        XStream xstream = new XStream(new DomDriver())
        xstream.alias("team", Team.class)
        xstream.alias("players", java.util.ArrayList.class)
        xstream.alias("player", Player.class)
        xstream.alias("positions", java.util.ArrayList.class)
        xstream.alias("position", Position.class)
        team = (Team) xstream.fromXML(str)
        return team
    }
    
}
