# Example-Java-API-TEF

Este é um projeto para exemplo de integração com a API TEF da Aditum feito em Java. Ele demonstra como integrar e utilizar as funcionalidades do TEF em um ambiente Java.

### Funções disponíveis neste projeto:

- `init`: Para inicializar o PinPad com nosso Gerenciador padrão.
- `payment`: Realizar um pagamento.
- `Confirm`: Confirmar uma transação.
- `Cancelation`: Cancelar uma transação.
- `Reversal`: Reverter uma transação (Que esteja como Pendente).
- `GetPeding`: Buscar transações pendentes.
- `Display`: Disparar uma mensagem para o PinPad (com até 32 caracteres).

### Estrutura do Projeto

- `domain/`: Contém as principais classes de objetos utlizados no projeto.
- `servico/`: Servico contém os arquivos responsáveis pelas chamadas e respostas enviadas e recebidas pela API.
- `util/`: Possuí as classes com funções úteis utilizadas no projeto, para conversões de valores, certificado.
- `Main.Java`: Arquivo principal para execução do programa.

## Configuração do Projeto

Execute o seguinte comando para compilar o projeto:
```
javac Main.java
```

## Executar o Programa

Para executar o programa, utilize o seguinte comando:
```
java Main.java
```

### Atenção

- Para compilar e executar o projeto é obrigatório possuir JRE e JDK instalados na sua máquina.

- Sempre que o projeto for "buildado" e executado é necessário passar pelo init
antes das outras funções, para que a autenticação da API seja realizada somente
uma vez.
