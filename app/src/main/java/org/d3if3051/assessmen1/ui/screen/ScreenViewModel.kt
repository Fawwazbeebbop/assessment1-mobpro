package org.d3if3051.assessmen1.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3051.assessmen1.model.History

class ScreenViewModel : ViewModel() {
    val data = getDataDummy()

    private fun getDataDummy(): List<History>{
        val data = mutableListOf<History>()
        data.add(
            History(
                "Period 1 2024",
                "305000.01 IDR"
            )
        )
        data.add(
            History(
                "Period 2 2023",
                "250000.60 IDR"
            )
        )
        data.add(
            History(
                "Period 1 2023",
                "620000.30 IDR"
            )
        )
        data.add(
            History(
                "Period 2 2022",
                "540000.60 IDR"
            )
        )
        data.add(
            History(
                "Period 1 2022",
                "345500.35 IDR"
            )
        )
        data.add(
            History(
                "Period 2 2021",
                "846700.34 IDR"
            )
        )
        data.add(
            History(
                "Period 1 2021",
                "678900.56 IDR"
            )
        )
        data.add(
            History(
                "Period 2 2020",
                "234600.80 IDR"
            )
        )
        data.add(
            History(
                "Period 1 2020",
                "904300.90 IDR"
            )
        )
        data.add(
            History(
                "Period 2 2019",
                "120000.60 IDR"
            )
        )
        return  data
    }
}