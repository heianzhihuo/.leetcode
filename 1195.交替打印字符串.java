/*
 * @lc app=leetcode.cn id=1195 lang=java
 *
 * [1195] 交替打印字符串
 */

// @lc code=start
class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i<=n){
            if(i%3==0 && i%5!=0){
                printFizz.run();
                i++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i<=n){
            if(i%3!=0 && i%5==0){
                printBuzz.run();
                i++;
            }
        }
    
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i<=n){
            if(i%3==0 && i%5==0){
                printFizzBuzz.run();
                i++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i<=n){
            if(i%3!=0 && i%5!=0){
                printNumber.accept(i);
                i++;
            }
        }
    }
}
// @lc code=end

