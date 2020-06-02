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

 

 
 ## Versão
  
| Componente     |  Versão  |
| -------------- | ---------|
|  TCPServer     |  1.0     |
  
  
  **Contato**
* leonardobarrosbhz@gmail.com 
  
