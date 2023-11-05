public class CounterApp {

    public static void main(String[] args) {
        // Создаем два потока счетчика
        Thread counter1 = new Thread(new Counter(), "Counter 1");
        Thread counter2 = new Thread(new Counter(), "Counter 2");

        // Запускаем потоки
        counter1.start();
        counter2.start();
    }

    static class Counter implements Runnable {
        private int count = 0;
        private final int limit = 10; // Допустим, каждый счетчик считает до 10

        @Override
        public void run() {
            while (count < limit) {
                count++; // увеличиваем счетчик
                System.out.println(Thread.currentThread().getName() + ": " + count);

                // Активное ожидание (не рекомендуется, но используем в демонстрационных целях)
                long endTime = System.nanoTime() + 500_000_000; // примерно 0.5 секунды
                while (System.nanoTime() < endTime) {
                    // пустой цикл для имитации задержки
                }
            }
        }
    }
}