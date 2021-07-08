### SERTÃO PROTOCOLO

login e senha dos usuarios:

##### ADMIN
- login: ananias
- senha: ananias123

##### USER_ADMIN
- login: leonardo
- senha: leo123

##### USER
- login: nias
- senha: nias123


##### TECNOLOGIAS USADAS

<ul>
	<li>IDE: IntelliJ IDEA</li>
	<li>SGBD: PostgreSQL</li>
	<li>Java Version (11)</li>
	<li>Framework: Spring (2.4.4)</li>
	<li>Template Engine: Thymeleaf </li>
</ul>

##### INFORMAÇÕES ADICIONAIS

Caso necessario alterar a porta ou o nome do banco de dados, ou o usuario ou a senha;

resources/application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/sertao_protocolo
spring.datasource.username=postgres
spring.datasource.password=postgres

#### DESCRIÇÃO

Essa aplicação tem como objetivo facilitar o acompanhamento e abertura de protocolos seja no setor público ou privado por parte do funcionário ou servidor, tendo uma melhor visualização, segurança, transparência e tempo de resposta reduzido.

A aplicação conta com a área dos usuários responsáveis, onde os mesmos administram os protocolos criados pelos usuários funcionários, onde ele poderá visualizar, editar e responder os protocolos dos seus funcionários para as respectivas solicitações, efetuando as devidas respostas  e ou os devidos procedimentos acerca desses pedidos, poderá efetuar o cadastro de novos funcionários, editar informações, visualizar informações e fazer se necessário o desligamento do funcionário, isto claro se o mesmo tiver as devidas permissões, que serão abordadas mais à frente. O sistema ainda pode emitir avisos ou alertas para todos os funcionários ou para um grupo de funcionário em específico e ou  até mesmo para um funcionário em específico.

Ainda na parte dos usuários responsáveis vamos mostrar as permissões, bem como definir cada uma para o melhor entendimento. Abaixo está listado as permissões e suas definições;

1. Administrador: Tem permissão completa sobre o sistema e sobre tudo que é feito, bem como permissão para acessar a base de dados do sistema;
2. Usuário responsável: O mesmo tem permissão para fazer as devidas consultas de forma geral, bem como cadastros, consultas, alterações e desligamentos, mas não tem acesso a logs do sistema ou qualquer tipo de acesso direto ao banco de dados. Ressalto ainda que dentro o usuário responsável a algumas sub-permissões, elas são:

	2.1 Leitura: Pode fazer consultas, não pode efetuar nenhuma alteração no sistema;

	2.2 Escrita: Pode fazer a escrita de novos registro no sistema, mais o mesmo não pode alterar esses registros;

	2.3 Sobrescrita: Pode fazer alteração em registros que já foram criados;

	2.4 Desligamento: Pode tornar inativos registros que uma vez foram criados no sistema;

	2.5 Importação/Exportação: Pode importar dados de outras fontes como excel ou exportar para as mesmas;

Agora vamos abordar a parte do usuário funcionário, o mesmo após fazer login tem a possibilidades de efetuar cadastro de novos protocolos e pode alterá-los e ou cancelá-los, se e somente se o protocolo em questão ainda estiver pendente, pois a partir do momento que o protocolo estiver em anelize o mesmo somente pode ser visualizado por o usuário em questão. O usuário tem uma tela com todos os seus protocolos onde pode efetuar filtros e acompanhar o andamento de cada um tendo assim mais velocidade na abertura de protocolo, mais transparência quanto a análise e mais velocidade quanto a resposta. Ainda o usuário funcionário pode receber alertas e ou avisos em sua tela inicial cadastrado pelos usuários responsáveis.

Salientamos ainda que se caso a política da empresa permite às solicitações serviram como documentação para comprovação de determinados protocolos, tanto da parte da empresa quanto da parte do funcionário.

##### TECNOLOGIAS USADAS

1. Linguagem de Programação Java 11 
2. Postgresql
3. Maven
4. Bootstrap 5.0.0
5. Spring Boot 2.4.4
	5.1. Spring Data JPA
	5.2. Spring Web
	5.3. Thymeleaf
	5.4. Spring DevTools
	5.5. Driver Postgresql
	5.6. Lombok

##### DIAGRAMA DE ENTEIDADE RELACIONAL

[![ER](https://github.com/MeninoNias/PBD_20-1_Ananias-Raphael/blob/development/sert%C3%A3o-protocolo-er.png "ER")](https://github.com/MeninoNias/PBD_20-1_Ananias-Raphael/blob/development/sert%C3%A3o-protocolo-er.png "ER")

