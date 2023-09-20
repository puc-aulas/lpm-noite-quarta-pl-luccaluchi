# Código do Projeto

## Estrutura do projeto (locadora):
``` 
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── locadora
│   │               ├──***Classes Pricipais***
│   └── test
│       └── java
│           ├── ***Classes de teste***
└── target
    ├── classes
    │   └── com
    │       └── locadora
    |           ├──***Classes Pricipais Compiladas***
    └── test-classes
        ├── ***Classes de teste Compiladas***
```

## Instruções para utilização:
1. Navegue até o diretório *locadora*
2. execute o seguinte comando para compilar e executar a aplicação:
```bash
mvn clean compile exec:java
```

## Executar testes:
1. Testes das classes *Aluguel*, *Cliente* e *Equipamento*:
```bash
mvn -Dtest=AluguelTest,ClienteTest,EquipamentoTest test         
```
2. Para rodar os testes da classe *Registro* é necessário executar um método por vez:
```bash
mvn -Dtest=RegistroTest#throwCasoNaoExistaOEquipamento test
mvn -Dtest=RegistroTest#throwCasoNaoExistaOCliente test
mvn -Dtest=RegistroTest#throwCasoNaoHajaQuantidadeSuficiente test
mvn -Dtest=RegistroTest#throwCasoDataDeTerminoSejaAnteriorADataDeInicio test
mvn -Dtest=RegistroTest#deveRealizarOAluguelCorretamente test
mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoCliente test
mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoMesEFaturamento test
```
3. Para executar tudo utilize o script *runtests.sh* (linux)
```bash
chmod +x runtests.sh
./runtests.sh
```