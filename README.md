# ✔️TaskApp

> Status: Finalizado✅

### Sobre o projeto:

Uma aplicação responsável por gerenciar as tarefas de um único usuário. É possível adicionar projetos e tarefas, como também, é possível editar e excluir as tarefas existentes, todas as informações adicionadas pelo usuário na aplicação são salvas no banco de dados.
##
### Tecnologias utilizadas:
A aplicação foi desenvolvida totalmente em Java, utilizando o Java Swing para a construção da interface gráfica.  <br/>
Como banco de dados, foi utilizado o MySQL.

<div>
  <table> 
    <tr> 
      <td>MySQL </td>
      <td>JDBC </td>
      <td>JDK </td>
    </tr>
    <tr>
      <td> 8.X </td>
      <td> 8.0.X </td>
      <td> 17 </td>
    </tr>
  </table>
</div>

##


### Rodando a aplicação:

<img alt="TaskAppImage" height="450" src="https://cdn.discordapp.com/attachments/468483471468265492/1031792840994463804/TaskApp.png">
<br/>
[Vídeo em breve]


##

### Como rodar a aplicação em sua máquina:

1) Clone o repositório;
2) Importe o projeto na sua IDE; 
3) Inicie o MySQL/Apache;
4) Entre na pasta "Banco_de_Dados" e importe o arquivo "gerenciadordetarefas.sql" no MySQL;
5) Inicie MainScreen.java

### Em caso de erro com o banco de dados: 

1) Crie um novo banco de dados com as tabelas "projects" e "tasks"

2) As tabelas "projects" e "tasks" devem ser estruturada da seguinte forma:

[Modelos em breve]

3) Após a criação e configuração do novo banco de dados, acesse o arquivo "ConnectionFactory.java" e configure as variáveis de acordo com as configurações do novo SGBD:
<div>
<img alt="ConnectionFactoryImage" height="300" src="https://cdn.discordapp.com/attachments/468483471468265492/1031791099347488798/ConnectionFactory.png">
</div>




