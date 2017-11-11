package com.renaro.iseeyou.model

/**
 * Created by renarosantos1 on 10/11/17.
 */

enum class Quota(val title: String, val code: Int) {

    AIRCRAFT("Aircraft renting or charter of aircraft", 119),
    AUTOMOTIVE("Automotive vehicle renting or charter", 120),
    AUTOMOTIVE2("Automotive vehicle renting or watercraft charter", 15),
    MEAL("Congressperson meal", 13),
    CONSULTANCY("Consultancy, research and technical work", 4),
    FLIGHT("Flight tickets", 9),
    FUELS("Fuels and lubricants", 3),
    LOCOMOTION("Locomotion, meal and lodging", 2),
    LODGING("Lodging, except for congressperson from Distrito Federal", 14),
    MAINTENANCE("Maintenance of office supporting parliamentary activity", 1),
    PARTICIPATION("Participation in course, talk or similar event", 137),
    POST("Postal services", 11),
    PUBLICATION("Publication subscriptions", 12),
    PUBLICITY("Publicity of parliamentary activity", 5),
    SUPPLY("Purchase of office supplies", 6),
    SECURITY("Security service provided by specialized company", 8),
    SOFTWARE("Software purchase or renting; Postal services; Subscriptions", 7),
    TAXI("Taxi, toll and parking", 122),
    TELECOMMUNICATION("Telecommunication", 10),
    TERRESTIAL("Terrestrial, maritime and fluvial tickets", 123),
    WATERCRAFT("Watercraft renting or charter", 121)


}

