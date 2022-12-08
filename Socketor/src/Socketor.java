

public class Socketor {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage:\r\n" +
                    "java Socketor server 8000 /\r\n" +
                    "java Socketor client 127.0.0.1 8000 45 35");
            return;
        }

        Socketor socketor = new Socketor();

        if (args[0].equals("server")) {
            socketor.runServer(args[1], args[2]);
        }

        if (args[0].equals("client")) {
            socketor.runClient(args[1], args[2], args[3], args[4]);
        }
    }

    private void runServer(String port, String operation) {
        Phone phone = new Phone(port);
        System.out.println("Started server with " + operation + " on " + port);
        while (true) {
            phone.accept();
            String a = phone.readLine();
            String b = phone.readLine();
            int result = calculate(operation, a, b);
            String message = a + " " + operation + " " + b + " = " + result;
            phone.writeLine(message);
            System.out.println("Accepted: " + message);
            phone.close();
        }
    }

    private int calculate(String operation, String a, String b) {
        int result = 0;
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);
        switch (operation) {
            case "+":
                result = intA + intB;
                break;
            case "-":
                result = intA - intB;
                break;
            case "*":
                result = intA * intB;
                break;
            case "/":
                result = intA / intB;
                break;
        }
        return result;
    }

    private void runClient(String ip, String port, String a, String b) {
        Phone phone = new Phone(ip, port);
        phone.writeLine(a);
        phone.writeLine(b);
        String answer = phone.readLine();
        System.out.println(answer);
        phone.close();
    }
}