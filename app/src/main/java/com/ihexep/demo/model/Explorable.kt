package com.ihexep.demo.model

import com.ihexep.demo.R

data class Explorable (
    val title: String,
    val desc: String,
    val iconId: Int
)

val DemoExplorables = listOf(
    Explorable("Midhill Hospital",
        "Earn KES 500 discount for having your baby at Midhill or referring a mother.",
        R.drawable.ic_mh_logo
    ),
    Explorable("Kingdom Bank",
        "Check-off loans of up to Kes 4 Million, is repayable in up to 96 months (8 years). ",
        R.drawable.ic_kb_logo
    )
)