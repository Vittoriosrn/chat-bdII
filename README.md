# Chat SCPIP

Projeto: sistema de chat cliente-servidor em Java.

## Como iniciar

Na raiz do projeto
1. **Compile** o código:
   ```bash
   javac -d out src/chat/*.java
   ```
2. **Inicie o servidor** (porta padrão 12345):
   ```bash
   java -cp out chat.Main server
   ```
3. **Conecte um cliente** (no mesmo PC ou em outro na rede):
   ```bash
   java -cp out chat.Main client <IP-do-servidor> <porta>
   ```

## Sobre

- Troca de mensagens em tempo real
- Suporta múltiplos clientes
- Salva histórico em `messages.txt`
