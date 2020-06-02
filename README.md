# Servidor TCP - Multithread
###### Projeto Basico para um Servidor TCP 
Este projeto tem como objetivo a criação de um Servidor TCP, onde ao inicia-lo é possivel definir a porta a ser utilizado.

O Objetivo deste servidor é estar apto a atender diversos serviços sendo executados em varias portas. 
A principio já tem um serviço implementado para testes. Este serviço serviço realiza uma busca por Titulos de Filmes no site do IMDB 
(https://www.imdb.com), caso haja alguma alteração no layout do site, possivelmente este serviço não mais será valido.

## Servico "Busca de Titulos de Filmes"
O serviço de busca de filmes utiliza Payloads.</br>

- Para Request:<br>
*\<query length\>:\<query\>*  

- Para Response:<br>
*\<payload length\>:\<payload\>*

OBS: 1. O comprimento da query e payload não deve considerar o ':' separador.
     
     
*Exemplo:*<br>
Consulta: Star Trek <br>
- Request =>  9:Star Trek

Resposta: Star Trek O Filme <br>
- Response =>  17:Star Trek O Filme


## Tecnologias

- Java JDK 8   -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Gradle       -> https://docs.gradle.org
- JSoup        -> https://jsoup.org

## Testando o Servidor e Serviços

###### Java Instalado?


- Verificando se o java esta instalado

1. Em seu Windows 10, clique na Lupa e digite "cmd".
2. Em seguida clique sobre a "Prompt de Comando"
3. Digite *java -version* e aperte *"Enter"*
 
Se o retorno for algo similar a isto:<br>
java version "1.8.0_211"<br>
Java(TM) SE Runtime Environment (build 1.8.0_211-b12)<br>
Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)<br>

O java esta instalado em seu PC.<br>
 
Caso contrario, sera necessario instala-lo.</br> Link para fazer o donwload da instalação https://www.oracle.com/technetwork/java/javase/overview/index.html </br> Selecione o arquivo, conforme seu sistema operacional.
Depois de baixar o arquivo JDK, basta executa-lo e seguir os passo da isntalação.

###### Testando o Servidor

**Passo 1 Baixando o arquvio  TCPServe-1.0.jar**
 
 1. Vá até o Projeto
 2. Na Raiz do Projeto existe a Pasta **app** Acesse ela.
 3. Clique sobre o arquivo **TCPServe-1.0.jar**
 4. Uma nova pagina sera aberta, clique no botão donwload
 5. Salve o arquivo em seu computador
 
 **Passo 2 Executando o arquivo**
 1. Acesse o prompt de comando
 2. Navegue pelas pastas ate onde foi salvo o arquivo *TCPServer-1.0.jar*
 3. No prompt de comando digite o seguinte comando: <br>
 *java -jar TCPServer-1.0.jar [--port]*
 >Obs: O Paramentro port é opcional, caso não seja informado, o servidor iniciara na porta 5551 
 
 ## Versão
  
| Componente     |  Versão  |
| -------------- | ---------|
|  TCPServer     |  1.0     |
  
  
  **Contato**
* leonardobarrosbhz@gmail.com 
  
