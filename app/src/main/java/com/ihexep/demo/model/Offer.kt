package com.ihexep.demo.model

import com.ihexep.demo.R

data class Offer(
    val title: String,
    val iconId: Int
)

val DemoOffers = listOf(
    Offer("App Download", R.drawable.ic_app_download),
    Offer("Event Tickets", R.drawable.ic_event_tickets),
    Offer("Healthcare", R.drawable.ic_healthcare),
    Offer("Insurance", R.drawable.ic_insurance),
    Offer("Loans", R.drawable.ic_loans)
)