# Trabalho final DM110 – JavaEE

Professor: Msc. Roberto Ribeiro Rocha

Alunos:

* Isabel Mendes
* Rodrigo Donizetti
* Tiago Carvalho

#### Passo a passo para executar o serviço:

1. Clonar o repositório https://github.com/rodrigodonizettio/dm110-javaee-homework.git.
2. Importar o projeto no Eclipse. Usar como base o arquivo “Prática Aula 3 - Criar nova estrutura de projetos Java EE_19857.pdf” apresentado em sala de aula.
3. Configurar o servidor Wildfly. Usar como base o arquivo “Prática Aula 1 - Configurar e executar o Wildfly_19546.pdf” apresentado em sala.
4. Criar a fila “productqueue”. Usar como base o arquivo “Prática Aula 3 - Configuração das filas JMS no WildFly (via CLI)_19855.pdf” apresentado em sala.
5. Criar o driver e o database do Postgres: "PRODUCT_DS". As tabelas não necessitam ser criadas, pois o código faz isso sozinho. Para isso, usar como base o arquivo “Prática Aula 2 - Configuração do Postgres no Wildfly_19590.pdf” apresentado em sala.



#### API referentes aos serviços REST

Utilizando a ferramenta Postman as seguintes requests foram verificadas:

1. ###### Criar produto:

   Endpoint: http://127.0.0.1:8080/product-web/api/product

   Rest: POST

   ```
   Body: {
   	"code": 987654,
   	"name": "Vídeo Porteiro",
   	"description": "Vídeo Porteiro 4 câmeras",
   	"price": 450.00,
   	"category": "Eletrônicos"
   }
   ```

   


2. ###### Atualizar produto

   Endpoint: http://127.0.0.1:8080/product-web/api/product

   REST: PUT

   ```
   Body: {
   	"code": 987654,
   	"name": "Vídeo Porteiro",
   	"description": "Vídeo Porteiro 4 câmeras",
   	"price": 450.00,
   	"category": "Eletrônicos"
   }
   ```

   


3. ###### Listar um produto específico:

   Endpoint: http://127.0.0.1:8080/product-web/api/product/123456

   REST: GET

4. ###### Listar todos os produtos

   Endpoint: http://127.0.0.1:8080/product-web/api/product

   REST: GET

5. ###### Listar todas as auditorias dos produtos

   Endpoint: http://127.0.0.1:8080/product-web/api/audit

   REST: GET