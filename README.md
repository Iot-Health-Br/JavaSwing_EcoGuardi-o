# JavaSwing_EcoGuardião

## Trata-se de um sistema desenvolvido em JavaSwing na estrutura MVC usando uma arquitetura monolitica.

### O usuário executa a copilação do código, após inicialização do sistema apresenta a tela de login.

![Captura de tela 2023-12-16 140432](https://github.com/Iot-Health-Br/JavaSwing_EcoGuardiao/assets/47635759/bb9e9f0b-2cc0-4a6c-b090-84b0d901aa2b)

### Como trata-se de um código de teste, deixei que o usuário escolha o seu tipo de permissão >Usuário/Analista< durante o cadastro.

> [!NOTE]
> O cadastro do usuário e armazenado dentro de um banco de dados, estamos usando o postgres.

![Captura de tela 2023-12-16 141510](https://github.com/Iot-Health-Br/JavaSwing_EcoGuardiao/assets/47635759/9e12283d-2e6d-4c5e-9879-cb5c6a549e08)

### Após o cadastro ele retorna na tela de login, efetua o login que abre na tela pertinente ao cadastro.

#### >Tela Usuário.
> [!IMPORTANT]
> O usuário só consegue visualizar suas denuncias criadas.

![Captura de tela 2023-12-16 141548](https://github.com/Iot-Health-Br/JavaSwing_EcoGuardiao/assets/47635759/198dbe6e-ec46-410e-906b-75a4b1f3fc14)

#### >Tela Analista.

> [!NOTE]
> O analista consegue alterar algumas informações da denuncia.
> - [x] Status
> - [x] Sigilo
> - [x] Categoria
> - [x] Municipio 

![Captura de tela 2023-12-16 142217](https://github.com/Iot-Health-Br/JavaSwing_EcoGuardiao/assets/47635759/489e7548-1f01-44c7-8ee0-e3930a95ad31)

> [!IMPORTANT]
> O analista consegue visualizar e alterar todas as denuncias criadas no sistema ecoguardião.

> [!WARNING]
> O sistema EcoGuardião não está 100% concluido.
> Falta vincular os restante dos campos das denuncias para o usuário e analista.
> Implementar o SQL de criação da tabela denuncia, com as alterações acima
> O sistema está funcionado, o usuário consegue criar um denuncia previa e o analista consegue visualiza-lá e alterar o seu status e parametros.





