# Academic System - Trabalho Final (IFCE)

Projeto mínimo para o trabalho final da disciplina *Tópicos em Java para a Web*.

## Como executar (Eclipse / IntelliJ / VS Code)
1. Importar como projeto Maven (pom.xml).
2. Executar `br.ifce.academics.AcademicSystemApplication` como aplicação Spring Boot.
3. Acessar `http://localhost:8080`.
4. H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:academics`, user `sa`).

## Usuários seed
- admin / admin123 (ROLE_ADMIN)
- secretaria / sec123 (ROLE_SECRETARIA)

## Observações
- Banco: H2 (memória).
- Build: Maven.
- Este projeto inclui implementações básicas de: entidades, repositórios, serviços, controllers, security e views Thymeleaf.
- O PDF de especificação foi incluído no pacote: `/mnt/data/TJW_2025_2___Trabalho_Final.pdf`

