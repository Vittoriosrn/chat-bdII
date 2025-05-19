public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Uso: java Main server [porta] | java Main client <host> [porta]");
            return;
        }
        if ("server".equalsIgnoreCase(args[0])) {
            String[] sub = args.length > 1 ? new String[]{args[1]} : new String[0];
            Server.main(sub);
        } else if ("client".equalsIgnoreCase(args[0])) {
            String host = args.length > 1 ? args[1] : "localhost";
            String port = args.length > 2 ? args[2] : "12345";
            Client.main(new String[]{host, port});
        } else {
            System.out.println("Parâmetro inválido: " + args[0]);
        }
    }
}
