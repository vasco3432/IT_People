#Exercício 1)

##Requisitos de ambiente:

-Se possível executar no sistema operativo Windows – Caso contrário terá que se fazer instalação manual da driver e editar o ficheiro environment.properties - localização : {MyProj_directory}/src/main/java/config
-Ter o computador devidamente configurado com a versão java 1.8 ou superior
-Ter o computador devidamente configurado com o maven, idealmente com a versão 3.6.3 ou superior
-Ter o Google Chrome instalado
-Ter acesso à internet

##Execução:

-Por defeito o programa leva a chromedriver para a versão 91 do chrome. Caso exista algum problema de compatibilidade, executar o ficheiro getDriver.ps1 - localização: {MyProj _directory}/driver - que irá fazer download a uma versão compatível da driver e inserir na diretoria configurada por defeito em environment.properties.
-A partir da diretoria do projeto/raiz do project, abrir a linha de comandos e inserir o comando “mvn clean test” 

##Report:

O output da execução será apresentado em {project_directory}/target/{flow_name} e irá conter um ficheiro html, um json e um xml, consonte as necessidades de análise de resultados do projeto.

#Exercício 2

##Create User:

###Response Body

{ “_id” : “automatically generated numeric value”, "name": "User Name", "age": "25" }

###Assertions:

• statusCode = 201

• user schema validation is ok

• user id is equals to request id = not null and not empty and automatically generated numeric value

• name and age fields are "User Name " and "25".

##Update User:

###Response Body

{ “_id” : “1234567890”, "name": "User Name New", "age": "25" }

###Assertions:

• statusCode = 200

• user schema validation is ok

• user id is equals to request id = 1234567890 

• name and age fields are "User Name New" and "25".

##Delete user:

###Response Body – No Body

###Assertions:

 • statusCode = 204 


