# 🌱 Harvestime API

Backend da aplicação **HarvesTime**, desenvolvido com **Spring Boot** em Java, responsável por gerenciar dados relacionados a fazendas, sensores, dispositivos e leituras ambientais. Esta API fornece os dados consumidos pelo app mobile React Native.

## 📌 Funcionalidades

- Cadastro e gerenciamento de usuários
- Cadastro de fazendas com endereço completo
- Associação de sensores e dispositivos a fazendas
- Registro e consulta de leituras de temperatura e umidade
- Geração de alertas com base em condições extremas
- Configuração de thresholds por sensor

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Lombok
- Maven
- Docker
- Oracle SQL
- Swagger (para documentação da API)

## 🚀 Como Executar o Projeto

### 1. Pré-requisitos

- Java 21
- Maven
- Docker (opcional, para containerizar)
  
### 2. Rodando com Maven

```bash
./mvnw spring-boot:run
````

A API estará disponível em:
`http://localhost:8080`

### 3. Rodando com Docker

```bash
docker build -t harvestime-app .
docker run -p 8080:8080 harvestime-app
```

## 📚 Estrutura do Projeto

```
harvestime-api-main/
├── controller/     # Endpoints REST da aplicação
├── dto/            # Objetos de transferência de dados organizados por domínio
├── entity/         # Entidades do banco de dados
├── repository/     # Interfaces de persistência com Spring Data
├── HarvestimeApplication.java  # Classe principal
├── Dockerfile
└── pom.xml
```

## 🧪 Resultados de Testes

Aqui serão adicionadas imagens de testes da API e exemplos de resposta:

![image](https://github.com/user-attachments/assets/0bee93ff-2222-4176-9bfb-0685bb6a6211)

![image](https://github.com/user-attachments/assets/cee90d4e-6faa-4bb0-8735-9a5f541188f1)

![image](https://github.com/user-attachments/assets/22e0c48f-5899-4a3c-86e0-eb5fc4af663b)

![image](https://github.com/user-attachments/assets/0a593371-b900-4cee-bcb1-991287636310)

![image](https://github.com/user-attachments/assets/0a804af6-58a1-45e4-ae68-19d69a04c65d)

![image](https://github.com/user-attachments/assets/da3fa7f2-4f53-43b8-bb5c-3f4a0f9480fd)

![image](https://github.com/user-attachments/assets/a4156304-5fa8-468c-ac4c-3afa47f25748)

---

## 🙋‍♂️ Autor

Desenvolvido por **Guilherme Cardoso**
Projeto acadêmico para gestão e monitoramento agrícola com tecnologias modernas.
