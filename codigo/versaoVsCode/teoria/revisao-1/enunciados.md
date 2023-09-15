# Básicos

01 - Escreva códigos Java para preencher um vetor de 6 números inteiros a partir da entrada do usuário e, depois, inverter as posições dos números do vetor. Por exemplo, se o vetor original era 4-8-15-16-23-42, deve ficar 42-23-16-15-8-4 após a execução. Escreva um programa que verifique a correção do seu código..


02 - Escreva códigos Java que leiam um vetor de inteiros e criem outro vetor, contendo a soma de cada par de vizinhos do vetor original. Por exemplo, se o vetor original era 4-8-15-16-23-42, o retorno deve ser um vetor 12-31-65 (ou seja, 4+8, 15+16 e 23+42). Caso o vetor tenha tamanho ímpar, o último número deve ser somado consigo mesmo. Para ler o vetor, pode aproveitar o método do exercício 02. Escreva um programa que execute e teste seu código..

03 – Escreva um ou mais métodos para imprimir no console retângulos usando caracteres, como, por exemplo:
```
XXXXX
X   X
X   X
X   X
XXXXX
```

04 - Elabore um programa que leia uma frase e mostre-a invertida na tela. Após mostrar a primeira frase, o programa deve ler e imprimir outra, assim fazendo até que o usuário digite a palavra “fim”.

# Aplicados

05 – Um estudante muito organizado está matriculado em N disciplinas, e dispõe de um total semanal de H horas e M minutos para estudar. Sua intenção é dividir o tempo disponível igualmente para as N disciplinas, e distribuir o tempo de descanso que sobrar nas pausas entre as disciplinas. Crie um ou mais métodos para informar ao estudante como ele deve organizar seu plano de estudos.


06 – Mensalmente, a organização de moradores do bairro faz um sorteio cujos bilhetes contêm números de 6 dígitos. O sorteio é baseado nos dois primeiros números da loteria federal, sendo que o número vencedor no sorteio da organização é formado pelos três primeiros dígitos do segundo prêmio e os três últimos dígitos do primeiro prêmio da loteria federal. Por exemplo, se o primeiro prêmio fosse 34.582 e o segundo 54.098, o número vencedor seria 540.582. Escreva um programa que leia os prêmios da loteria federal e retorna o número vencedor da organização.

07 - Um algoritmo para multiplicação rápida por 11 de números de 2 dígitos funciona assim: para multiplicar 81 x 11, some os dígitos do número (8 + 1 = 9) e insira o resultado entre os dígitos (891). Se a soma der maior que 9, incremente o dígito da esquerda (vai-um): 56 x 11 = 616. Escreva um programa que efetue multiplicações por 11 usando este algoritmo.

08 - Escreva um método que verifique se uma data é válida, a partir de um dado recebido do usuário no formato DD/MM/AAAA. Se a data for inválida, informe ao usuário onde está o erro.

09 - Sabendo que 1º de janeiro de 2024 será uma segunda feira, escreva um método que receba uma data e diga em qual dia da semana esta data acontecerá em 2024. Escreva um programa principal para testar seu método.

# Uso de arquivos

10 - Refaça o exercício 02, sendo que os dados serão lidos de um arquivo texto. O arquivo texto pode ter várias linhas e cada linha representa um vetor a ser utilizado pelo método. O separador usado é ponto e vírgula. Por exemplo:

```
4;8;15;4;15;16;23;42
7;11;13;17;29;23;29;31
6;5;4;3;2;1
```

11 - Refaça o exercício 08, adicionando a capacidade de ler várias datas de um arquivo texto. O arquivo conterá, em sua primeira linha, o número de datas das linhas seguintes. Por exemplo,

```
4
12/02/2013
14/11/2019
31/04/2020
26/01/2021
```

12 - Refaça o exercício 04, fazendo com que o programa leia de um arquivo todas as frases a serem impressas de forma invertida. A última linha deste arquivo terá a palavra “fim”.

# TEÓRICOS

13 – O que é um método em um código de um sistema de informação?


14 – Por que é aconselhável dividir sistemas em métodos separados uns dos outros?


15 – Defina o que é um parâmetro utilizado em um método Java. Depois de definir, explique por que é importante termos parâmetros em métodos.


16 – O que acontece com um dado passado por parâmetro para um método após a execução deste método?


17 – Para cada situação abaixo, cite estruturas de dados que você utilizaria em sistemas de informação que precisam destes dados para resolver o problema. Observe o exemplo para dar suas respostas:


**EXEMPLO:** Um praticante realiza uma série de exercícios em sua academia a cada dia da semana.

**RESP:** Cada entidade praticante pode ter um vetor ou lista estática com os dias da semana (que é um dado conhecido e imutável). Cada dia da semana conterá uma fila de exercícios a serem feitos, assumindo que a ordem deles é importante.


**b)** Uma oficina mecânica realiza diversos serviços em automóveis. Cada automóvel pode ter recebido muitos serviços ao longo de sua existência. Um automóvel está sempre associado a um proprietário, que pode ser pessoa física ou jurídica (empresa).


**c)** Um candidato possui uma série de habilidades para se candidatar a vagas de emprego. Cada vaga tem suas habilidades específicas exigidas e deve possuir um conjunto de candidatos hábeis, destacando aquele que for mais adequado para a vaga no momento.


**d)** Um posto de saúde atende a milhares de pacientes. O posto tem um calendário anual de vacinação e cada paciente possui um prontuário com as vacinas tomadas, incluindo seu nome, lote e data de aplicação.