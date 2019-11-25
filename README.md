## Trabalho final DM110 � JavaEE

Professor: Msc. Roberto Ribeiro Rocha

####Alunos:
Isabel Mendes
Rodrigo Donizetti
Tiago Carvalho

####Passo a passo para executar o servi�o:
- Clonar o reposit�rio https://github.com/rodrigodonizettio/dm110-javaee-homework.git.
- Importar o projeto no Eclipse. Usar como base o arquivo �Pr�tica Aula 3 - Criar nova estrutura de projetos Java EE_19857.pdf� apresentado em sala de aula.
- Configurar o servidor Wildfly. Usar como base o arquivo �Pr�tica Aula 1 - Configurar e executar o Wildfly_19546.pdf� apresentado em sala.
- Criar a fila �productqueue�. Usar como base o arquivo �Pr�tica Aula 3 - Configura��o das filas JMS no WildFly (via CLI)_19855.pdf� apresentado em sala.
- Criar o driver e o database do Postgres: "PRODUCT_DS". As tabelas n�o necessitam ser criadas, pois o c�digo faz isso sozinho. Para isso, usar como base o arquivo �Pr�tica Aula 2 - Configura��o do Postgres no Wildfly_19590.pdf� apresentado em sala.



####API referentes aos servi�os REST
Utilizando a ferramenta Postman as seguintes requests foram verificadas:
#####1. Criar produto:
Endpoint: http://127.0.0.1:8080/product-web/api/product
Rest: POST
Body: {
	"code": 987654,
	"name": "V�deo Porteiro",
	"description": "V�deo Porteiro 4 c�meras",
	"price": 450.00,
	"category": "Eletr�nicos"
}

#####2. Atualizar produto
Endpoint: http://127.0.0.1:8080/product-web/api/product/{code}
REST: PUT
Body: {
	"code": 987654,
	"name": "V�deo Porteiro",
	"description": "V�deo Porteiro 4 c�meras",
	"price": 450.00,
	"category": "Eletr�nicos"
}

#####3. Listar um produto espec�fico:
Endpoint: http://127.0.0.1:8080/product-web/api/product/123456
REST: GET

#####4. Listar todos os produtos
Endpoint: http://127.0.0.1:8080/product-web/api/product
REST: GET

#####5. Listar todas as auditorias dos produtos
Endpoint: http://127.0.0.1:8080/product-web/api/audit
REST: GET

###End