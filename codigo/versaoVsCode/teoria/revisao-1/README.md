## Revisão de Programação Modular em Java

Neste repositório, você encontrará as implementações das questões propostas, cada uma organizada em uma classe separada para facilitar a compreensão e os testes individuais. Além disso, é possível utilizar o Test Runner para executar testes automatizados e verificar se as implementações estão corretas.

### Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

- **`/bin`**: Diretório onde as classes compiladas estão localizadas.

- **`/lib`**: Diretório contendo as bibliotecas externas necessárias para os testes.

   - `hamcrest-core-1.3.jar`: Biblioteca Hamcrest utilizada pelo JUnit.
   - `junit-4.13.2.jar`: Biblioteca JUnit para execução de testes.

- **`/src`**: Diretório principal contendo o código-fonte e os pacotes.

   - **`/main`**: Pacote principal contendo a implementação das questões.

   - **`/mock`**: Diretório para armazenar arquivos de entrada para questões que leem de arquivos.

   - **`/test`**: Pacote de testes contendo classes de teste para cada questão.

   - **`App`**: Classe principal que serve como ponto de entrada do programa.
   - **`TestRunner`**: Classe que executa os testes automatizados.

# Requisitos
- Esse projeto foi desenvolvido utilizando o Java Development Kit (JDK): Certifique-se de ter o JDK instalado em sua máquina. Utilizei a versão 17.0.8 do OpenJDK.
- Certifique-se de atualizar os caminhos para os arquivos mock nas variáveis `QUESTION10_FILE_NAME`, `QUESTION11_FILE_NAME` e `QUESTION12_FILE_NAME` no arquivo `App.java`. Esses caminhos devem apontar para os arquivos corretos em seu sistema, localizados na pasta `mock`.

# Executando o Programa e os Testes

1. Certifique-se de que você possui o ambiente de desenvolvimento Java (JDK) instalado em sua máquina.

2. Clone este repositório.

3. Abra o terminal e navegue até a pasta raiz.

4. Compile o código-fonte executando o seguinte comando no terminal:

   ```
   javac -d bin src/App.java src/main/java/*/*.java
   ```

   E compile também os testes:

   ```
   javac -d bin -cp lib/junit-4.13.2.jar:bin src/test/java/questao_*/*Test.java src/TestRunner.java
   ```

5. Após compilar com sucesso, acesse a pasta `bin`:

   ```
   cd bin
   ```

6. Execute o programa principal com o seguinte comando:

   ```
   java App
   ```

7. Siga as instruções apresentadas no menu para executar e testar as questões individualmente.

8. Para executar os testes automatizados, execute o Test Runner com o seguinte comando:

   ```
   java -cp .:../lib/junit-4.13.2.jar:../lib/hamcrest-core-1.3.jar TestRunner
   ```

   Certifique-se de que os arquivos JAR do JUnit estão na pasta `lib`.

### Resultados dos Testes

O Test Runner exibirá informações sobre os testes para cada questão implementada. Para cada questão, você verá uma indicação "OK" se todos os testes passaram com sucesso ou "FALHA" se algum teste falhou. Se houver falhas, os detalhes das falhas também serão apresentados.