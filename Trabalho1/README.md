# <img width=20 src="https://static.vecteezy.com/system/resources/previews/015/280/601/original/hand-drawn-genes-and-dna-illustration-png.png"> DNA alienigina <img width=20 src="https://static.vecteezy.com/system/resources/previews/015/280/601/original/hand-drawn-genes-and-dna-illustration-png.png">

<div align="center">
  <img width="100" src="https://media1.giphy.com/media/TfARDpUutt1W2jgDBY/200w.gif?cid=6c09b9521dunvclng2szhkyn0659jn50snjgh4fl7him5jzk&ep=v1_gifs_search&rid=200w.gif&ct=s">
</div>

Esta pasta contém a implementação de um algoritmo em Java para resolver o problema da análise do DNA de alienígenas. O objetivo do problema é determinar o tamanho da menor cadeia que pode ser obtida após todas as mutações possíveis.

## ℹ️ Informações

- **Autores:** Maria Maia
- **Data:** 15/08/2023
- **Status:** Concluído
- **Linguagem:** Java
- **Descrição:** análise do DNA de alienígenas.
- **Link:** https://github.com/DudaWendelMaia/ALEST_2.git

## 🎯 Problema

Os cientistas descobriram que o DNA alienígena possui características distintas do DNA terrestre e é composto por três bases: D, N e A. Além disso, o DNA alienígena sofre mutações ao longo do tempo, resultando em sua deterioração. As mutações ocorrem da seguinte forma:

- A fusão de bases ocorre sempre na dupla de bases diferentes mais à esquerda da cadeia de DNA.
- A nova base criada a partir da fusão é adicionada ao final da cadeia de DNA.

Por exemplo, uma cadeia de DNA pode sofrer deterioração em "DN" e se transformar em "AA". Cadeias maiores, como "DNAND ANDANDANAD NDDDAN", podem se simplificar para "N" após várias mutações.


## 🌟 Implementação
O algoritmo Java implementado neste projeto lê as cadeias de DNA fornecidas nos diversos arquivos de teste pelos cientistas e determina o tamanho da menor cadeia que pode ser obtida após todas as mutações possíveis. O código-fonte está organizado da seguinte forma:

### Classe Principal (Main)
- Main.java é a classe principal que inicia a execução do programa.
- Usa um Scanner para interagir com o usuário através de um menu.
- Permite ao usuário escolher entre realizar a mutação e calcular o tamanho da menor cadeia possível, exibir a sequência de DNA original ou sair do programa.

### Mutação do DNA (MutacaoDNA)
- MutacaoDNA.java contém a lógica para realizar as mutações no DNA alienígena.
- O método realizarMutacao recebe uma lista encadeada de caracteres representando a cadeia de DNA.
- Itera pela lista, fundindo bases diferentes adjacentes à esquerda e adicionando a nova base ao final.
- Retorna a lista resultante após todas as mutações.

## ▶️ Como Executar

Certifique-se de ter o JDK instalado. Clone o repositório e compile o código Java.

1. Clone o repositório:
    ```sh
    git clone https://github.com/DudaWendelMaia/ALEST_2.git
    ```

2. Navegue até a pasta do projeto:
    ```sh
    cd Trabalho1
    ```

3. Compile o código:
    ```sh
    javac Main.java
    ```

4. Execute o programa:
    ```sh
    java Main
    ```
5. O programa apresentará um menu interativo que permitirá que você escolha entre realizar a mutação e calcular o tamanho da menor cadeia possível, exibir a sequência de DNA original ou sair do programa.
- Para realizar a mutação e calcular o tamanho da menor cadeia possível, escolha a opção 1 e insira o nome do arquivo de entrada quando solicitado.
- Para exibir a sequência de DNA original, escolha a opção 2. Note que você deve primeiro realizar a mutação para ter uma sequência mutada disponível.
- Para sair do programa, escolha a opção 3.

---

Espero que este trabalho tenha sido útil! 😊
