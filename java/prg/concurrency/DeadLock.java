package prg.concurrency;

import prg.Out.Util;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private static class Account {
        private Object resource1 = new Object();
        private Object resource2 = new Object();

        private ReentrantLock lock1 = new ReentrantLock();
        private ReentrantLock lock2 = new ReentrantLock();
        private int balance = 10;

        public void deposit(int amt) {
            System.out.println("Deposit Require resource1 first.");
            synchronized (resource1) {
                int a = getBalance();
                // adding some delay while aquiring second lock
                Util.sleep(500, TimeUnit.MILLISECONDS);
                synchronized (resource2) {
                    setBalance(a + amt);
                }
            }

            // this won't be printed because of deadlock.
            System.out.println("New Balance after deposit := " + getBalance());
        }

        public void deposit2(int amt) {
            System.out.println("Deposit Require resource1 first.");
            try {
                if (lock1.tryLock()) {
                    int a = getBalance();
                    // adding some delay while aquiring second lock
                    Util.sleepMillis(5000);
                    if (lock2.tryLock())
                        setBalance(a + amt);
                }
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }

            // this won't be printed because of deadlock.
            System.out.println("New Balance after deposit := " + getBalance());
        }

        public void withdraw(int amt) {
            System.out.println("Withdraw Require resource2 first.");

            synchronized (resource2) {
                int a = getBalance();
                // adding some delay while aquiring second lock
                Util.sleepMillis(1000);
                synchronized (resource1) {
                    setBalance(a - amt);
                }
            }

            // this won't be printed because of deadlock.
            System.out.println("New Balance after withdrawal := " + getBalance());
        }

        public void withdraw2(int amt) {
            System.out.println("Withdraw Require resource2 first.");

            try {
                if (lock2.tryLock()) {
                    int a = getBalance();
                    // adding some delay while aquiring second lock
                    Util.sleepMillis(1000);
                    if (lock1.tryLock())
                        setBalance(a - amt);

                }
            } finally {
                lock2.unlock();
                lock1.unlock();
            }

            // this won't be printed because of deadlock.
            System.out.println("New Balance after withdrawal := " + getBalance());
        }
        private int getBalance() {
            return balance;
        }

        private void setBalance(int amt) {
            balance = amt;
        }
    }

    public static void main(String[] args) {
        Account account = new Account();

        Runnable r1 = () -> account.deposit2(5);
        Runnable r2 = () -> account.withdraw2(5);
        ForkJoinPool.commonPool().submit(r1);
        ForkJoinPool.commonPool().submit(r2);

        while (! Thread.interrupted()) {
            Util.sleepMillis(10000);
        }
    }

}
