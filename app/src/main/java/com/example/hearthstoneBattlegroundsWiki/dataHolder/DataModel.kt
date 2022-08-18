package com.example.dota2herowiki.dataHolder

data class DataModel(
    val cards: List<Card?>?,
    val cardCount: Int?,
    val pageCount: Int?,
    val page: Int?
) {
    data class Card(
        val id: Int?,
        val collectible: Int?,
        val slug: String?,
        val classId: Int?,
        val multiClassIds: List<Any?>?,
        val cardTypeId: Int?,
        val cardSetId: Int?,
        val rarityId: Int?,
        val artistName: String?,
        val health: Int?,
        val manaCost: Int?,
        val name: String?,
        val text: String?,
        val image: String?,
        val imageGold: String?,
        val flavorText: String?,
        val cropImage: String?,
        val childIds: List<Int?>?,
        val battlegrounds: Battlegrounds?,
        val attack: Int?,
        val keywordIds: List<Int?>?,
        val minionTypeId: Int?,
        val duels: Duels?
    ) {
        data class Battlegrounds(
            val hero: Boolean?,
            val companionId: Int?,
            val image: String?,
            val imageGold: String?,
            val tier: Int?,
            val upgradeId: Int?
        )

        data class Duels(
            val relevant: Boolean?,
            val constructed: Boolean?
        )
    }
}