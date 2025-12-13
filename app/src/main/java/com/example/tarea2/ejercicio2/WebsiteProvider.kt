package com.example.tarea2.ejercicio2

import com.example.tarea2.R

object WebsiteProvider {
    val websiteList = listOf(
        Website(
            "El Pimpi",
            "https://www.elpimpi.com",
            "Taberna emblemática en centro histórico de Málaga",
            "https://www.elpimpi.com/reservas/",
            R.drawable.elpimpi  // <- Imagen local
        ),
        Website(
            "La Cosmopolita",
            "No tiene web",
            "Cocina malagueña tradicional con toque moderno",
            "https://www.instagram.com/lacosmopolitamalaga/?hl=es",
            R.drawable.lacosmopolita  // <- Imagen local
        ),
        Website(
            "Casa Lola",
            "https://grupocasalola.com",
            "Tapas y vinos en el corazón de Málaga",
            "https://www.instagram.com/grupocasalolamalaga/?hl=es",
            R.drawable.casa_lola_logo  // <- Imagen local
        ),
        Website(
            "Uvedoble Taberna",
            "https://www.uvedobletaberna.com",
            "Taberna moderna con productos locales",
            "https://www.instagram.com/taberna_uvedoble/?hl=es",
            R.drawable.uvedoble_logo  // <- Imagen local
        ),
        Website(
            "Antigua Casa de Guardia",
            "https://antiguacasadeguardia.com",
            "Bodega fundada en 1840, la más antigua de Málaga",
            "antiguacasadeguardia@gmail.com",
            R.drawable.antiguacasadeguardia  // <- Imagen local
        )
    )
}