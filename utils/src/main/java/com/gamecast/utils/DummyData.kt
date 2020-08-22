package com.gamecast.utils

class DummyData {
    companion object{
        // DUMY DATA
        val sampleLiveJson =  mapOf(
                "title" to "AHORA/LIGA MX/ESTADIO UNIVERSITARIO/FINALES",
                "isLive" to true,
                "local" to "Chivas",
                "visitor" to "Atlas",
                "minutes" to 45,
                "local_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_chivas.png",
                "visitor_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_atlas.png",
                "local_live_score" to 0,
                "visitor_live_score" to 2,
                "local_prediction" to 1,
                "visitor_prediction" to 4
        )

        val sampleMatchJson =  mapOf(
                "title" to "5 DIAS/LIGA MX/ESTADIO BBVA/FINALES",
                "isLive" to false,
                "local" to "Rayados",
                "visitor" to "Tigres",
                "minutes" to 0,
                "local_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_rayados.png",
                "visitor_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_tigres.png",
                "local_live_score" to 0,
                "visitor_live_score" to 0,
                "local_prediction" to 0,
                "visitor_prediction" to 1
        )

        val sampleMatchJson2 =  mapOf(
                "title" to "5 DIAS/LIGA MX/ESTADIO BBVA/FINALES",
                "isLive" to false,
                "local" to "Toluca",
                "visitor" to "Pachuca",
                "minutes" to 0,
                "local_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_toluca.png",
                "visitor_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_pachuca.png",
                "local_live_score" to 0,
                "visitor_live_score" to 0,
                "local_prediction" to 3,
                "visitor_prediction" to 2
        )

        val sampleMatchJson3 =  mapOf(
                "title" to "5 DIAS/LIGA MX/ESTADIO BBVA/FINALES",
                "isLive" to false,
                "local" to "Queretaro",
                "visitor" to "Tijuana",
                "minutes" to 0,
                "local_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_queretaro.png",
                "visitor_logo" to "https://gamecastimgs.s3.us-west-2.amazonaws.com/teams/e_tijuana.png",
                "local_live_score" to 0,
                "visitor_live_score" to 1,
                "local_prediction" to 1,
                "visitor_prediction" to 3
        )

        val trophiesDummy = arrayListOf(mapOf(
                "trophy" to "champion",
                "message" to "",
                "achieved" to true,
                "name" to "champion_name",
                "content" to "champion_content"
        ),mapOf(
                "trophy" to "gamblinggod",
                "message" to "",
                "achieved" to true,
                "name" to "gamblinggod_name",
                "content" to "gamblinggod_content"
        ),mapOf(
                "trophy" to "weekmaster",
                "message" to "",
                "achieved" to false,
                "name" to "weekmaster_name",
                "content" to "weekmaster_content"
        ),mapOf(
                "trophy" to "gamblinglord",
                "message" to "",
                "achieved" to true,
                "name" to "gamblinglord_name",
                "content" to "gamblinglord_content"
        ),mapOf(
                "trophy" to "gamblingmaster",
                "message" to "",
                "achieved" to false,
                "name" to "champion_name",
                "content" to "champion_content"
        ),mapOf(
                "trophy" to "host",
                "message" to "",
                "achieved" to false,
                "name" to "host_name",
                "content" to "host_content"
        ),mapOf(
                "trophy" to "onehitwonder",
                "message" to "",
                "achieved" to true,
                "name" to "champion_name",
                "content" to "champion_content"
        ))
    }
}