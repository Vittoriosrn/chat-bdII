# Chat SCPIP

Projeto: sistema de chat cliente-servidor em Java.

## Como iniciar

1. **Compile** o código:
   ```bash
   javac src/*.java
   ```
2. **Inicie o servidor** (porta padrão 12345):
   ```bash
   java -cp src Main server
   ```
3. **Conecte um cliente** (no mesmo PC ou em outro na rede):
   ```bash
   java -cp src Main client <IP-do-servidor>
   ```

## Sobre

- Troca de mensagens em tempo real
- Suporta múltiplos clientes
- Salva histórico em `messages.txt`
