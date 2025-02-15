<div align="center">
    <a href="https://www.linkedin.com/in/izaiasvalentim/"><img alt="Linkedlin" src="https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555"></a>
    <a href="https://github.com/IzaiasValentim/sis-tarefas-esig/blob/main/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/YousefIbrahimismail/Project-README-Template?color=ff69b4&style=for-the-badge"></a>
</div>
<br>

<!-- Project title 
* use a dynamic typing-SvG here https://readme-typing-svg.demolab.com/demo/
*
*  Instead you can type your project name after a # header
-->

<div align="center">
<a href="#"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=33&pause=1000&duration=1&color=004d9b&background=26FFDE0F&center=true&vCenter=true&width=480&lines=Sis-Tarefas" alt="Typing SVG" /></a>
</div>

<div>
  <h2 align="center">Sobre & Motivação
  </h2>
</div>

Como parte do recrutamento para Estágio em desenvolvimento Java WEB na ESIG GROUP, um dos processos seletivos é uma atividade técnica. A atividade em questão consiste em criar um gerenciador de tarefas.

O Sis-Tarefas é o resultado da minha atividade. A aplicação possibilita o manuseio de uma tarefa como a criação, visualização, edição e exclusão de tarefas além da criação de usuários/responsáveis que podem ser delegados às mesmas.

### Resumo de funcionalidades e itens implementados
- [X] Aplicação Java Web:
    - Utilização do framework PrimeFaces;
    - CRUD de Tarefas;
    - Tabela de visualização e filtragem dinâmica das tarefas, e
    - Criação e exclusão de responsáveis.
- [X] Persistência em banco de dados PostgreSQL.
- [X] Aplicação da especificação JPA.

<div align="center">
  <h2>Requisitos | Informações técnicas | Execução</h2>
</div>

### Principais Requisitos
- **Java**: `17`
- **PostgreSQL**: `16`
- **WildFly**: `35.0.1.Final`

 ### Dependências  
Estas são as dependências da aplicação:  
- **Jakarta EE 10 API**: Fornece um conjunto de APIs padrão para desenvolvimento de aplicações empresariais Java.  
- **Jakarta Server Faces 4.0**: Framework para criação de interfaces web baseadas em componentes.
- **PrimeFaces**: Biblioteca de componentes UI para Jakarta Faces.  
- **PrimeFlex**: Conjunto de utilitários CSS para layouts responsivos e estilização de componentes. 
- **Injeção de Dependências (CDI API)**: Suporte à injeção de dependências no contexto do Jakarta EE.  
- **PostgreSQL Driver**: Driver JDBC para conexão com bancos de dados PostgreSQL.  
- **Hibernate Core**: Implementação do JPA (Java Persistence API) para mapeamento objeto-relacional.  
- **Hibernate EntityManager**: Integração do Hibernate com o gerenciamento de entidades do JPA.  

### Passos para execução:

#### 1. Clone este repositório e acesse a pasta da aplicação
   Acesse pelo terminal a pasta de download do repositório e execute:
   ```bash  
   git clone https://github.com/IzaiasValentim/sis-tarefas-esig 
   cd sis-tarefas-esig/sis-tarefas
   ```
#### 2. Configure na sua IDE a execução da aplicação com o WildFly

#### 3. No painel de controle do WildFly, configure seu Data Source com o driver do PostgreSQL e JNDI Name: 'SisTarefas'

#### 4. Execute a aplicação e a acesse, onde por padrão será: http://localhost:8080/sis-tarefas-1.0-SNAPSHOT/
  -  Pode varia de acordo com o contexto ou porta de execução definido para execução do WildFly.

#### Creditos:
- [Sample readme](https://github.com/YousefIbrahimismail/Project-README-Template/tree/main)
- [Github markdown](https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
- [Readme Typing SVG](https://readme-typing-svg.demolab.com/demo/)
