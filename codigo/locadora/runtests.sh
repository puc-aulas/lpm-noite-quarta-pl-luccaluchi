#!/bin/bash

mvn -Dtest=AluguelTest,ClienteTest,EquipamentoTest test

mvn -Dtest=RegistroTest#throwCasoNaoExistaOEquipamento test
mvn -Dtest=RegistroTest#throwCasoNaoExistaOCliente test
mvn -Dtest=RegistroTest#throwCasoNaoHajaQuantidadeSuficiente test
mvn -Dtest=RegistroTest#throwCasoDataDeTerminoSejaAnteriorADataDeInicio test
mvn -Dtest=RegistroTest#deveRealizarOAluguelCorretamente test
mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoCliente test
mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoMesEFaturamento test
