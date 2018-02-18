package rabbitmq.workqueues;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static rabbitmq.basic.Send.QUEUE_NAME;

public class Worker {
    public static void main(String[] args) {
        new ReceiveTask("1TEST1").start();
        new ReceiveTask("2TEST2").start();
    }

    private static class ReceiveTask extends Thread {
        private String name;

        public ReceiveTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                channel.basicQos(1);
                Consumer consumer = new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        String message = new String(body, "UTF-8");

                        System.out.println(" [x + " + name + "] Received '" + message + "'");
                        try {
                            doWork(message);
                        } catch (InterruptedException e) {
                            System.out.println("Exception: " + e.getLocalizedMessage());
                        } finally {
                            System.out.println(" [x + " + name + "] Done");
                            channel.basicAck(envelope.getDeliveryTag(), false);
                        }
                    }
                };
                boolean autoAck = false; // acknowledgment is covered below
                channel.basicConsume(QUEUE_NAME, autoAck, consumer);
            } catch (TimeoutException | IOException e) {
                System.out.println("Exception: " + e.getLocalizedMessage());
            }
        }

        private static void doWork(String task) throws InterruptedException {
            for (char ch : task.toCharArray()) {
                if (ch == '.') Thread.sleep(1000);
            }
        }
    }
}
