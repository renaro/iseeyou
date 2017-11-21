package com.renaro.iseeyou.model

/**
 * Created by renarosantos1 on 10/11/17.
 */

enum class Quota(val title: String, val code: Int) {

    AIRCRAFT("Aluguel ou fretamento de Aeronaves", 119),
    AUTOMOTIVE("Aluguel ou fretamento de veículos ", 120),
    AUTOMOTIVE2("Aluguel de veículos automotivos ou embarcações", 15),
    MEAL("Refeição do congressista", 13),
    CONSULTANCY("Consultoria, pesquisa e trabalho técnico.", 4),
    FLIGHT("Passagens aéreas", 9),
    FUELS("Combustível e Lubrificantes", 3),
    LOCOMOTION("Locomoção, alimentação e alojamento.", 2),
    LODGING("Alojamento, exceto para congressista do Distrito Federal.", 14),
    MAINTENANCE("Manutenção do gabinete e suporte de atividades parlamentares.", 1),
    PARTICIPATION("Participação em curso, palestras ou eventos similares.", 137),
    POST("Serviços Postais", 11),
    PUBLICATION("Assinaturas de Publicação", 12),
    PUBLICITY("Publicidade de atividades parlamentares.", 5),
    SUPPLY("Compra de suprimentos para o gabinete.", 6),
    SECURITY("Serviço de segurança provido por empresas especializadas.", 8),
    SOFTWARE("Aluguel ou compra de Softwares. Serviços Postais e Assinaturas.", 7),
    TAXI("Taxi, pedágio e estacionamento.", 122),
    TELECOMMUNICATION("Telecomunicação", 10),
    TERRESTIAL("Bilhetes terrestres, marítmos e fluviais.", 123),
    WATERCRAFT("Aluguel de embarcações", 121)


}

